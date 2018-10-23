package com.blink22.skeleton.di.module

import com.blink22.skeleton.di.PerActivity
import com.blink22.skeleton.ui.splash.presenter.SplashPresenter
import com.blink22.skeleton.ui.splash.presenter.SplashPresenterImp
import com.blink22.skeleton.ui.splash.view.SplashView
import dagger.Module
import dagger.Provides

/**
 * Created by Islam Salah on 10/23/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
@Module
class ActivityModule {

    @Provides
    @PerActivity
    fun provideSplashPresenter(presenter: SplashPresenterImp<SplashView>):
            SplashPresenter<SplashView> = presenter
}