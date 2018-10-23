package com.blink22.skeleton.ui.base.presenter

import com.blink22.skeleton.data.DataManager
import com.blink22.skeleton.ui.base.view.BaseView

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
abstract class BasePresenterImp<V : BaseView>(val dataManager: DataManager) : BasePresenter<V> {

    private var view: V? = null

    override fun attachView(view: V?) {
        this.view = view
    }

    override fun dropView() {
        this.view = null
    }
}