package com.gojek.trendingrepo.data.local.db

import com.gojek.trendingrepo.data.models.db.Repository
import io.reactivex.Observable
import javax.inject.Inject

class AppDbHelper @Inject constructor(val appDatabase: AppDatabase) :DbHelper {

    override fun insertRepository(repository: Repository): Observable<Boolean> =  Observable.fromCallable<Boolean> {
        appDatabase.repositoryDao().insert(repository)
        true
    }

    override fun insertRepositories(repositories: List<Repository>): Observable<Boolean> = Observable.fromCallable<Boolean> {
        appDatabase.repositoryDao().clearRepos()
        appDatabase.repositoryDao().insertAll(repositories)
        true
    }

    override val allRepositories: Observable<List<Repository>>
        get() = Observable.fromCallable<List<Repository>> {
                 appDatabase.repositoryDao().loadAll()
        }


    override fun clearRepositories(): Observable<Boolean>  = Observable.fromCallable<Boolean> {
        appDatabase.repositoryDao().clearRepos()
        true
    }
}