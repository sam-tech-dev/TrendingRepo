package com.gojek.trendingrepo.ui.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.gojek.trendingrepo.data.AppDataManager
import com.gojek.trendingrepo.data.models.db.Repository
import com.gojek.trendingrepo.utils.AppSchedulerProvider
import java.util.*


class MainViewModel constructor( val appDataManager: AppDataManager, val schedulerProvider: AppSchedulerProvider ) : BaseViewModel<MainNavigator>() {

     val repositoryAdapter = RepositoryAdapter()


    fun  setDataToView(){
        isLoading.set(true)
        compositeDisposable.add(
            appDataManager.allRepositories
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    if(it.size>0){
                        isLoading.set(false)
                        repositoryAdapter.updateRepoList(it)
                    }else{
                        fetchTrendingRepositories()
                    }
                },{
                    isLoading.set(false)
                    Log.e("az","error "+it)
                }))
    }


    fun  fetchTrendingRepositories(){
        compositeDisposable.add(
            appDataManager.getTrendingRepos()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    insertReposintoDatabase(it)
                    repositoryAdapter.updateRepoList(it)
                    Log.e("az","response "+it)
                },{
                    isLoading.set(false)
                    Log.e("az","error "+it)
                }))
    }


    fun insertReposintoDatabase(repoList: List<Repository>){
        compositeDisposable.add(
            appDataManager.insertRepositories(repoList)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    isLoading.set(false)
                    Log.e("az","response "+it)
                },{
                    isLoading.set(false)
                    Log.e("az","error "+it)
                }))
    }

}