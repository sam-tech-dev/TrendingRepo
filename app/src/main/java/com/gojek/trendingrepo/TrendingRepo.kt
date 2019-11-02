package com.gojek.trendingrepo

import android.app.Activity
import android.app.Application
import com.gojek.trendingrepo.di.component.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TrendingRepo : Application(), HasActivityInjector {


    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    companion object {

        lateinit var app :TrendingRepo

        fun getInstance(): TrendingRepo{
            return  app
        }
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()

        app=this

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }


}