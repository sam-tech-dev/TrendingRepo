package com.gojek.trendingrepo.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.gojek.trendingrepo.data.AppDataManager
import com.gojek.trendingrepo.utils.AppSchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel constructor( val appDataManager: AppDataManager, val schedulerProvider: AppSchedulerProvider ) : BaseViewModel<MainNavigator>() {



    fun  fetchTrendingRepositories(){

        compositeDisposable.add(
            appDataManager.getTrendingRepos()
                .doOnSuccess({
                  Log.e("az","response "+it)
                })
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    Log.e("az","response "+it)
                },{
                    Log.e("az","error "+it)
                }))

    }

}