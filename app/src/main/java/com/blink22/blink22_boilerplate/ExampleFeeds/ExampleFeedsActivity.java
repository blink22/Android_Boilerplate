package com.blink22.blink22_boilerplate.ExampleFeeds;

import com.blink22.blink22_boilerplate.AppInstance;
import com.blink22.blink22_boilerplate.ApplicationComponent;
import com.blink22.blink22_boilerplate.base.BaseActivity;
import com.blink22.core.modules.example.ExampleContract;

import javax.inject.Inject;

public class ExampleFeedsActivity extends BaseActivity {

    @Inject
    ExampleContract.Presenter presenter;

    @Override
    protected void injectDependencies(AppInstance application, ApplicationComponent component) {
        application.getExampleFeedsSubComponent().inject(this);
    }
}
