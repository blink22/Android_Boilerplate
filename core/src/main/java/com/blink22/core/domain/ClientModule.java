package com.blink22.core.domain;


import com.blink22.core.util.LanguageProvider;
import com.blink22.core.util.StateManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Mohsen on 20/10/2016.
 */

@Module
public class ClientModule {

    private static final String HTTP_CACHE_PATH = "http-cache";
    private static final String CACHE_CONTROL = "Cache-Control";
    private static final String PRAGMA = "Pragma";

    @Singleton
    @Provides
    public OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor,
                                            @Named("networkTimeoutInSeconds") int networkTimeoutInSeconds,
                                            @Named("isDebug") boolean isDebug,
                                            @Named("cache") Cache cache,
                                            @Named("cacheInterceptor") Interceptor cacheInterceptor,
                                            @Named("offlineInterceptor") Interceptor offlineCacheInterceptor,
                                            @Named("retryInterceptor") Interceptor retryInterceptor,
                                            @Named("HeaderInterceptor") Interceptor headers) {

        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .addNetworkInterceptor(cacheInterceptor)
                .addInterceptor(offlineCacheInterceptor)
                .addInterceptor(retryInterceptor)
                .addInterceptor(headers)
                .cache(cache)
                .connectTimeout(networkTimeoutInSeconds, TimeUnit.SECONDS);

        //show logs if app is in Debug mode
        if (isDebug)
            okHttpClient.addInterceptor(loggingInterceptor);

        return okHttpClient.build();
    }

    @Singleton
    @Provides
    public HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return logging;
    }

    @Provides
    @Singleton
    @Named("cache")
    public Cache provideCache(@Named("cacheDir") File cacheDir, @Named("cacheSize") long cacheSize) {
        Cache cache = null;

        try {
            cache = new Cache(new File(cacheDir.getPath(), HTTP_CACHE_PATH), cacheSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cache;
    }

    @Singleton
    @Provides
    @Named("cacheInterceptor")
    public Interceptor provideCacheInterceptor(@Named("cacheMaxAge") int maxAgeMin, @Named("cache") Cache cache) {
        return chain -> {
            Response response = chain.proceed(chain.request());

            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(maxAgeMin, TimeUnit.MINUTES)
                    .build();
            if(URLS.NO_CACHE_URLS.contains(chain.request().url().encodedPath())){
                cache.evictAll();
            }

            return response.newBuilder()
                    .removeHeader(PRAGMA)
                    .removeHeader(CACHE_CONTROL)
                    .header(CACHE_CONTROL, cacheControl.toString())
                    .build();
        };
    }


    @Singleton
    @Provides
    @Named("offlineInterceptor")
    public Interceptor provideOfflineCacheInterceptor(StateManager stateManager, @Named("cacheMaxStale") int maxStaleDay) {
        return chain -> {
            Request request = chain.request();

            if (!stateManager.isConnect()) {
                CacheControl cacheControl = new CacheControl.Builder()
                        .maxStale(maxStaleDay, TimeUnit.DAYS)
                        .build();

                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();
            }else{
                request = request.newBuilder()
                        .cacheControl(CacheControl.FORCE_NETWORK)
                        .build();
            }

            return chain.proceed(request);
        };
    }

    @Singleton
    @Provides
    @Named("retryInterceptor")
    public Interceptor provideRetryInterceptor(@Named("retryCount") int retryCount) {
        return chain -> {
            Request request = chain.request();
            Response response = null;
            IOException exception = null;

            int tryCount = 0;
            while (tryCount < retryCount && (null == response || !response.isSuccessful() )) {
                // retry the request
                try {
                    response = chain.proceed(request);
                } catch (IOException e) {
                    exception = e;
                }finally {
                    tryCount++;
                }
            }

            // throw last exception
            if (null == response && null != exception) {
                throw exception;
            }



            // otherwise just pass the original response on
            return response;
        };
    }

    @Singleton
    @Provides
    @Named("HeaderInterceptor")
    public Interceptor provideHeaders(@Named("appLanguage") LanguageProvider language) {
        return chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("X-Api-Key", URLS.API_KEY)
                    .header("Accept-Language",language.getCurrentLanguage())
//                    .header("X-Accept-Version","1.1.0")
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        };
    }


}
