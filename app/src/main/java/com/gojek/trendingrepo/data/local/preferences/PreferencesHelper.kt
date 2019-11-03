package com.beingmomin.mominapp.data.preferences


interface PreferencesHelper {

    fun setDbRefreshTimeMillis(timeMillis: Long)
    fun getDbRefreshTimeMillis(): Long
    fun clearAppPreferences()

}