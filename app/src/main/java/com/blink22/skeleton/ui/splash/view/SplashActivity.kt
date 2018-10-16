package com.blink22.skeleton.ui.splash.view

import android.os.Bundle
import com.blink22.skeleton.R
import com.blink22.skeleton.ui.base.view.BaseActivity

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
class SplashActivity : BaseActivity(), SplashView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}