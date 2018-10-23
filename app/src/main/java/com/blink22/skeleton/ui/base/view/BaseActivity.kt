package com.blink22.skeleton.ui.base.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.blink22.skeleton.SkeletonApplication
import com.blink22.skeleton.di.component.ActivityComponent
import com.blink22.skeleton.di.component.DaggerActivityComponent
import com.blink22.skeleton.di.module.ActivityModule

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
abstract class BaseActivity : AppCompatActivity(), BaseView {

    lateinit var component: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeActivityComponent()
    }

    private fun initializeActivityComponent() {
        component = DaggerActivityComponent.builder()
                .activityModule(ActivityModule())
                .applicationComponent((application as SkeletonApplication).component)
                .build()
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideKeyboard() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}