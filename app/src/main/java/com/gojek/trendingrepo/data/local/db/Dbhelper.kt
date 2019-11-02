package com.gojek.trendingrepo.data.local.db

import com.gojek.trendingrepo.data.models.db.Built
import com.gojek.trendingrepo.data.models.db.Repository
import io.reactivex.Observable

interface DbHelper {

    fun insertRepository(repository: Repository): Observable<Boolean>

    fun insertRepositories(repositories: List<Repository>): Observable<Boolean>

    val allRepositories: Observable<List<Repository>>

    fun insertBuilt(built: Built): Observable<Boolean>

    fun insertBuiltList(builts: List<Built>): Observable<Boolean>

    val allBuilts: Observable<List<Built>>


}
