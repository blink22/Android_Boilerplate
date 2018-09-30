package com.blink22.core.modules.example;

import dagger.Module;
import dagger.Provides;

@Module
public class ExampleModule {

    @Example
    @Provides
    public ExampleContract.Presenter providePresenter(ExamplePresenterImpl presenter){
        return presenter;
    }

    @Example
    @Provides
    public ExampleContract.Interactor provideInteractor(ExampleInteractorImpl interactor){
        return interactor;
    }
}
