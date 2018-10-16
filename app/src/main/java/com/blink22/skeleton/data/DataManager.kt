package com.blink22.skeleton.data

import com.blink22.skeleton.data.database.DbHelper
import com.blink22.skeleton.data.network.ApiHelper
import com.blink22.skeleton.data.preferences.PreferencesHelper

/**
 * Created by Islam Salah on 10/16/18.
 *
 * https://github.com/IslamSalah
 * islamsalah007@gmail.com
 */
interface DataManager : DbHelper, ApiHelper, PreferencesHelper {
}