package com.gojek.trendingrepo.data.remote


import com.gojek.trendingrepo.data.models.db.Repository
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class AppApiHelper @Inject constructor(val apiRequests: ApiRequests) : ApiHelper {

    override fun getTrendingRepos(): Single<List<Repository>> = apiRequests.getTrendingRepositories()

}