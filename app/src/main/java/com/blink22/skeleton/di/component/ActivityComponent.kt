package com.blink22.skeleton.di.component

import com.blink22.skeleton.di.PerActivity
import com.blink22.skeleton.di.module.ActivityModule
import com.blink22.skeleton.ui.splash.view.SplashActivity
import dagger.Component

/**
 * Created by Islam Salah on 10/23/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(splashActivity: SplashActivity)
}