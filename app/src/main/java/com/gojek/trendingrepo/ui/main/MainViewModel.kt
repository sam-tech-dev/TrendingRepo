package com.gojek.trendingrepo.ui.main

import android.util.Log
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.gojek.trendingrepo.data.AppDataManager
import com.gojek.trendingrepo.data.models.db.Repository
import com.gojek.trendingrepo.utils.AppSchedulerProvider
import java.util.*


class MainViewModel constructor( val appDataManager: AppDataManager, val schedulerProvider: AppSchedulerProvider ) : BaseViewModel<MainNavigator>() {

     val repositoryAdapter = RepositoryAdapter()
     val isSomethingWentWrong = ObservableBoolean()


    fun  setDataToView(){
        isSomethingWentWrong.set(false)
        isLoading.set(true)
        compositeDisposable.add(
            appDataManager.allRepositories
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    if(it.size>0){
                        if(check2HrCacheExpired()){
                            fetchTrendingRepositories()
                        }else{
                            isLoading.set(false)
                            isSomethingWentWrong.set(false)
                            repositoryAdapter.updateRepoList(it)
                        }
                    }else{
                        fetchTrendingRepositories()
                    }
                },{
                    isLoading.set(false)
                    isSomethingWentWrong.set(true)
                }))
    }


    fun  fetchTrendingRepositories(){
        compositeDisposable.add(
            appDataManager.getTrendingRepos()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    insertReposintoDatabase(it)
                    isSomethingWentWrong.set(false)
                    navigator?.stopRefreshing()
                    repositoryAdapter.updateRepoList(it)

                },{
                    isLoading.set(false)
                    navigator?.stopRefreshing()
                    isSomethingWentWrong.set(true)
                }))
    }

    fun insertReposintoDatabase(repoList: List<Repository>){
        compositeDisposable.add(
            appDataManager.insertRepositories(repoList)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    if(it){
                      appDataManager.setDbRefreshTimeMillis(System.currentTimeMillis())
                    }
                    isLoading.set(false)
                },{
                    isLoading.set(false)
                }))
    }


    fun check2HrCacheExpired(): Boolean{
        val millies2hr= 1000*60*60*2
        return  (System.currentTimeMillis()-appDataManager.getDbRefreshTimeMillis())>millies2hr
    }

}