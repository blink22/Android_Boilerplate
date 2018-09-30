package com.blink22.blink22_boilerplate;

import android.content.Context;

import com.blink22.blink22_boilerplate.util.AppSchedulerProvider;
import com.blink22.blink22_boilerplate.util.StateManagerImpl;
import com.blink22.core.domain.URLS;
import com.blink22.core.util.Constants;
import com.blink22.core.util.LanguageProvider;
import com.blink22.core.util.SchedulerProvider;
import com.blink22.core.util.StateManager;
import com.mirhoseini.utils.Utils;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;


/**
 * Created by m.hemdan on 8/16/17.
 */
@Module
public class ApplicationModule {
    @Provides
    @Singleton
    @Named("isDebug")
    boolean provideIsDebug() {
        return BuildConfig.DEBUG;
    }

    @Provides
    @Singleton
    @Named("networkTimeoutInSeconds")
    int provideNetworkTimeoutInSeconds() {
        return Constants.NETWORK_CONNECTION_TIMEOUT;
    }

    @Provides
    @Singleton
    HttpUrl provideEndpoint() {
        return HttpUrl.parse(URLS.BASE_URL);
    }

    @Provides
    @Named("appLanguage")
    LanguageProvider provideLanguage(){
        return new LanguageProvider();
    }

    @Provides
    @Singleton
    SchedulerProvider provideAppScheduler() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    @Named("cacheSize")
    long provideCacheSize() {
        return Constants.CACHE_SIZE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxAge")
    int provideCacheMaxAgeMinutes() {
        return Constants.CACHE_MAX_AGE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxStale")
    int provideCacheMaxStaleDays() {
        return Constants.CACHE_MAX_STALE;
    }

    @Provides
    @Singleton
    @Named("retryCount")
    public int provideApiRetryCount() {
        return Constants.API_RETRY_COUNT;
    }

    @Provides
    @Singleton
    @Named("cacheDir")
    File provideCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Provides
    @Named("isConnect")
    boolean provideIsConnect(Context context) {
        return Utils.isConnected(context);
    }

//    @Provides
//    FirebaseAnalytics provideFirebaseAnalytics(Context context) {
//        return FirebaseAnalytics.getInstance(context);
//    }

//    @Provides
//    FacebookImpl provideFacebookImpl(){
//        return FacebookImpl.getInstance();
//    }

    @Provides
    @Singleton
    public StateManager provideStateManager(StateManagerImpl stateManager) {
        return stateManager;
    }

}
