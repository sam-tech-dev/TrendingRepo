package com.gojek.trendingrepo.data

import com.gojek.trendingrepo.data.local.db.AppDbHelper
import com.gojek.trendingrepo.data.models.db.Built
import com.gojek.trendingrepo.data.models.db.Repository
import com.gojek.trendingrepo.data.remote.AppApiHelper
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class AppDataManager @Inject constructor(
    val appApiHelper: AppApiHelper,
    val appDbHelper: AppDbHelper ) : DataManager {


    override fun insertRepository(repository: Repository): Observable<Boolean> =
        appDbHelper.insertRepository(repository)

    override fun insertRepositories(repositories: List<Repository>): Observable<Boolean> =
        appDbHelper.insertRepositories(repositories)


    override val allRepositories: Observable<List<Repository>>
        get() = appDbHelper.allRepositories

    override fun insertBuilt(built: Built): Observable<Boolean> = appDbHelper.insertBuilt(built)

    override fun insertBuiltList(builts: List<Built>): Observable<Boolean> =
        appDbHelper.insertBuiltList(builts)

    override val allBuilts: Observable<List<Built>>
        get() = appDbHelper.allBuilts


    override fun getTrendingRepos(): Single<List<Repository>>
        = appApiHelper.getTrendingRepos()
}