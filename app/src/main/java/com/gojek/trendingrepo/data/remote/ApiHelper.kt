package com.gojek.trendingrepo.data.remote

import com.gojek.trendingrepo.data.models.db.Repository
import io.reactivex.Observable
import io.reactivex.Single

interface ApiHelper{
    fun getTrendingRepos(): Single<List<Repository>>
}