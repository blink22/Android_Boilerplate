package com.blink22.blink22_boilerplate;

import android.app.Application;
import android.content.Context;

import com.blink22.blink22_boilerplate.ExampleFeeds.ExampleFeedsSubComponent;
import com.blink22.core.modules.example.ExampleModule;
import com.blink22.core.util.LanguageProvider;

import java.util.Locale;

public class AppInstance extends Application {
    private static ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = createComponent();
        LanguageProvider.setCurrentLanguage(Locale.getDefault().getLanguage());

    }

    public ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
    }

    public static ApplicationComponent getComponent() {
        return component;
    }

    public static AppInstance get(Context context) {
        return (AppInstance) context.getApplicationContext();
    }


    private ExampleFeedsSubComponent exampleFeedsSubComponent;
    public ExampleFeedsSubComponent getExampleFeedsSubComponent(){
        return exampleFeedsSubComponent != null ? exampleFeedsSubComponent: (exampleFeedsSubComponent = createExampleFeedsSubComponent());
    }
    private ExampleFeedsSubComponent createExampleFeedsSubComponent(){
        return exampleFeedsSubComponent = component.plus(new ExampleModule());
    }
    public void releaseHomeSubComponent(){
        exampleFeedsSubComponent = null;
    }

}
