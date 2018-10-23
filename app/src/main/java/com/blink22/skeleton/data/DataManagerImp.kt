package com.blink22.skeleton.data

import com.blink22.skeleton.data.database.DbHelper
import com.blink22.skeleton.data.network.ApiHelper
import com.blink22.skeleton.data.preferences.PreferencesHelper
import javax.inject.Inject

/**
 * Created by Islam Salah on 10/23/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
class DataManagerImp @Inject constructor(val dbHelper: DbHelper, val apiHelper: ApiHelper, val preferencesHelper: PreferencesHelper) : DataManager {
}