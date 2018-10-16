package com.blink22.skeleton.ui.base.presenter

import com.blink22.skeleton.ui.base.view.BaseView

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
interface BasePresenter<V : BaseView> {

    fun attachView(view: V?)

    fun dropView()
}