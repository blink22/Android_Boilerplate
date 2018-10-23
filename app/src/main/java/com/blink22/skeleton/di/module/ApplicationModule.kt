package com.blink22.skeleton.di.module

import android.app.Application
import android.content.Context
import com.blink22.skeleton.data.DataManager
import com.blink22.skeleton.data.DataManagerImp
import com.blink22.skeleton.data.database.DbHelper
import com.blink22.skeleton.data.database.DbHelperImp
import com.blink22.skeleton.data.network.ApiHelper
import com.blink22.skeleton.data.network.ApiHelperImp
import com.blink22.skeleton.data.preferences.PreferencesHelper
import com.blink22.skeleton.data.preferences.PreferencesHelperImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
@Module
class ApplicationModule(val application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context = application

    @Provides
    @Singleton
    fun providesDbHelper(dbHelper: DbHelperImp): DbHelper = dbHelper

    @Provides
    @Singleton
    fun provideApiHelper(apiHelper: ApiHelperImp): ApiHelper = apiHelper

    @Provides
    @Singleton
    fun providePreferencesHelper(preferencesHelper: PreferencesHelperImp): PreferencesHelper =
            preferencesHelper

    @Provides
    @Singleton
    fun provideDataManager(dataManager: DataManagerImp): DataManager = dataManager
}