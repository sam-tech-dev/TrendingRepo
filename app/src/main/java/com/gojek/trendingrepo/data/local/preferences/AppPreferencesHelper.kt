package com.beingmomin.mominapp.data.preferences

import javax.inject.Inject


class AppPreferencesHelper @Inject constructor(var appPref: AppPreferences) : PreferencesHelper {

    companion object {
        const val PREF_KEY_DB_REFRESH_TIME_STAMP = "dbRefreshTimestamp"
    }

    override fun setDbRefreshTimeMillis(timeMillis: Long) = appPref.storePreferences(PREF_KEY_DB_REFRESH_TIME_STAMP, timeMillis)

    override fun getDbRefreshTimeMillis(): Long = appPref.fetchPreferences(PREF_KEY_DB_REFRESH_TIME_STAMP, 0L)

    override fun clearAppPreferences() = appPref.clearAllPreferences()

}