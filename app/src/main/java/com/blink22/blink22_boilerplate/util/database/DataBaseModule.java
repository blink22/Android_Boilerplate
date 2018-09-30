package com.blink22.blink22_boilerplate.util.database;

import com.blink22.core.util.DataBaseHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataBaseModule {
    @Provides
    @Singleton
    public DataBaseHelper provideDataBaseHelper(DataBaseHelperImpl dataBaseHelper){
        return dataBaseHelper;
    }
}