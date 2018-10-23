package com.blink22.skeleton.di

import javax.inject.Scope

/**
 * Created by Islam Salah on 10/23/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */

/**
 * In Dagger, an unscoped component cannot depend on a scoped component. As
 * ApplicationComponent  is a scoped component Singleton, we create a custom
 * scope to be used by all fragment components. Additionally, a component with a specific scope
 * cannot have a sub component with the same scope.
 */
@Scope
@Retention
annotation class PerActivity {
}