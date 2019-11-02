package com.gojek.trendingrepo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gojek.trendingrepo.R
import com.gojek.trendingrepo.ViewModelProviderFactory
import javax.inject.Inject
import androidx.lifecycle.ViewModelProviders
import com.gojek.trendingrepo.TrendingRepo
import dagger.android.AndroidInjection

class MainActivity : AppCompatActivity(),MainNavigator {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this,  factory).get(MainViewModel::class.java)
        mainViewModel.navigator = this

        mainViewModel.fetchTrendingRepositories()

    }


    override fun handleError(throwable: Throwable) {
        //
    }
}
