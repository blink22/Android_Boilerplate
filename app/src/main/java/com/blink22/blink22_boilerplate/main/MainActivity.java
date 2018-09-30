package com.blink22.blink22_boilerplate.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blink22.blink22_boilerplate.AppInstance;
import com.blink22.blink22_boilerplate.ApplicationComponent;
import com.blink22.blink22_boilerplate.R;
import com.blink22.blink22_boilerplate.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void injectDependencies(AppInstance application, ApplicationComponent component) {
        component.inject(this);
    }
}
