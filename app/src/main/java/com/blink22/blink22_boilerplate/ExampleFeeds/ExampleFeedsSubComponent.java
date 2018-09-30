package com.blink22.blink22_boilerplate.ExampleFeeds;

import com.blink22.core.modules.example.Example;
import com.blink22.core.modules.example.ExampleModule;

import dagger.Subcomponent;

@Example
@Subcomponent(modules = {ExampleModule.class})
public interface ExampleFeedsSubComponent {
    void inject(ExampleFeedsActivity activity);
}
