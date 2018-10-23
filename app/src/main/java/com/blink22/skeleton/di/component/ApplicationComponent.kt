package com.blink22.skeleton.di.component

import com.blink22.skeleton.data.DataManager
import com.blink22.skeleton.di.module.ApplicationModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    // Expose to sub graph
    fun provideDataManager(): DataManager
}