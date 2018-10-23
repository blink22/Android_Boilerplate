package com.blink22.skeleton

import android.support.multidex.MultiDexApplication
import com.blink22.skeleton.di.component.ApplicationComponent
import com.blink22.skeleton.di.component.DaggerApplicationComponent
import com.blink22.skeleton.di.module.ApplicationModule

/**
 * Created by Islam Salah on 10/18/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
class SkeletonApplication() : MultiDexApplication() {

    internal lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        initializeApplicationComponent()
    }

    private fun initializeApplicationComponent() {
        component = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}