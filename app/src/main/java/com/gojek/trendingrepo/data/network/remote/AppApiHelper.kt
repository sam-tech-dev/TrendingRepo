package com.gojek.trendingrepo.data.network.remote

import com.gojek.trendingrepo.data.network.models.TrendingReposResponse
import io.reactivex.Observable
import javax.inject.Inject

class AppApiHelper @Inject constructor(val apiRequests: ApiRequests) : ApiHelper {

    override fun getTrendingRepos(): Observable<TrendingReposResponse> = apiRequests.getTrendingRepositories()
}