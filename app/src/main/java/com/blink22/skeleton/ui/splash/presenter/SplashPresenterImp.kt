package com.blink22.skeleton.ui.splash.presenter

import com.blink22.skeleton.data.DataManager
import com.blink22.skeleton.ui.base.presenter.BasePresenterImp
import com.blink22.skeleton.ui.splash.view.SplashView
import javax.inject.Inject

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
class SplashPresenterImp<V : SplashView> @Inject constructor(dataManager: DataManager) : BasePresenterImp<V>(dataManager), SplashPresenter<V> {
}