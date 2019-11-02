package com.gojek.trendingrepo.data.local.db

import com.gojek.trendingrepo.data.models.db.Built
import com.gojek.trendingrepo.data.models.db.Repository
import io.reactivex.Observable
import java.util.concurrent.Callable
import javax.inject.Inject

class AppDbHelper @Inject constructor(val appDatabase: AppDatabase) :DbHelper {

    override fun insertRepository(repository: Repository): Observable<Boolean> =  Observable.fromCallable<Boolean> {
        appDatabase.repositoryDao().insert(repository)
        true
    }

    override fun insertRepositories(repositories: List<Repository>): Observable<Boolean> = Observable.fromCallable<Boolean> {
        appDatabase.repositoryDao().insertAll(repositories)
        true
    }

    override val allRepositories: Observable<List<Repository>>
        get() = Observable.fromCallable<List<Repository>> {
                 appDatabase.repositoryDao().loadAll()
        }

    override fun insertBuilt(built: Built): Observable<Boolean> =  Observable.fromCallable<Boolean> {
        appDatabase.builtDao().insert(built)
        true
    }

    override fun insertBuiltList(builts: List<Built>): Observable<Boolean> =  Observable.fromCallable<Boolean> {
        appDatabase.builtDao().insertAll(builts)
        true
    }

    override val allBuilts: Observable<List<Built>>
        get() = Observable.fromCallable<List<Built>> {
            appDatabase.builtDao().loadAll()
        }


}