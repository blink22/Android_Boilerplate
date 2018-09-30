package com.blink22.blink22_boilerplate;

import com.blink22.blink22_boilerplate.ExampleFeeds.ExampleFeedsSubComponent;
import com.blink22.blink22_boilerplate.main.MainActivity;
import com.blink22.blink22_boilerplate.util.database.DataBaseModule;
import com.blink22.core.domain.ApiModule;
import com.blink22.core.domain.ClientModule;
import com.blink22.core.modules.example.ExampleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by m.hemdan on 4/5/18.
 */
@Singleton
@Component(modules = {AndroidModule.class, ApplicationModule.class,
        ApiModule.class,ClientModule.class,
        DataBaseModule.class})
public interface ApplicationComponent {
    void inject(MainActivity activity);

    ExampleFeedsSubComponent plus(ExampleModule module);
}
