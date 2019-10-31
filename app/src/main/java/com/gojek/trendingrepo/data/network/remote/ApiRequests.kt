package com.gojek.trendingrepo.data.network.remote

import com.gojek.trendingrepo.data.network.models.TrendingReposResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiRequests {

    @GET("repositories")
    fun getTrendingRepositories(): Observable<TrendingReposResponse>

}