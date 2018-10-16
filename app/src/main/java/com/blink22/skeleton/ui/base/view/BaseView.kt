package com.blink22.skeleton.ui.base.view

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
interface BaseView {

    fun showLoading()

    fun hideLoading()

    fun showMessage(message: String)

    fun hideKeyboard()
}