package com.gojek.trendingrepo.data

import com.beingmomin.mominapp.data.preferences.AppPreferencesHelper
import com.gojek.trendingrepo.data.local.db.AppDbHelper
import com.gojek.trendingrepo.data.models.db.Repository
import com.gojek.trendingrepo.data.remote.AppApiHelper
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager @Inject constructor(
    val appApiHelper: AppApiHelper,
    val appDbHelper: AppDbHelper,
    val appPreferencesHelper: AppPreferencesHelper ) : DataManager {


    override fun insertRepository(repository: Repository): Observable<Boolean> =
        appDbHelper.insertRepository(repository)

    override fun insertRepositories(repositories: List<Repository>): Observable<Boolean> =
        appDbHelper.insertRepositories(repositories)


    override val allRepositories: Observable<List<Repository>>
        get() = appDbHelper.allRepositories


    override fun getTrendingRepos(): Single<List<Repository>>
        = appApiHelper.getTrendingRepos()

    override fun clearRepositories(): Observable<Boolean> =  appDbHelper.clearRepositories()


    override fun setDbRefreshTimeMillis(timeMillis: Long) = appPreferencesHelper.setDbRefreshTimeMillis(timeMillis)

    override fun getDbRefreshTimeMillis(): Long = appPreferencesHelper.getDbRefreshTimeMillis()

    override fun clearAppPreferences() = appPreferencesHelper.clearAppPreferences()
}