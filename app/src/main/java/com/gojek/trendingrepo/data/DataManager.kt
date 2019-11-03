package com.gojek.trendingrepo.data

import com.beingmomin.mominapp.data.preferences.PreferencesHelper
import com.gojek.trendingrepo.data.local.db.DbHelper
import com.gojek.trendingrepo.data.remote.ApiHelper

interface DataManager : DbHelper, ApiHelper,PreferencesHelper