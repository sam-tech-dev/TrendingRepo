package com.gojek.trendingrepo.data.remote

import com.gojek.trendingrepo.data.models.api.TrendingReposResponse
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiRequests {

    @GET("repositories")
    fun getTrendingRepositories(): Single<List<TrendingReposResponse>>

}