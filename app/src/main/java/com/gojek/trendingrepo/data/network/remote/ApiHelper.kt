package com.gojek.trendingrepo.data.network.remote

import com.gojek.trendingrepo.data.network.models.TrendingReposResponse
import io.reactivex.Observable

interface ApiHelper{
    fun getTrendingRepos(): Observable<TrendingReposResponse>
}