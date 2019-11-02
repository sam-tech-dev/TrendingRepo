package com.gojek.trendingrepo.data

import com.gojek.trendingrepo.data.local.db.DbHelper
import com.gojek.trendingrepo.data.remote.ApiHelper

interface DataManager : DbHelper, ApiHelper