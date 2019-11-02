package com.gojek.trendingrepo.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.gojek.trendingrepo.R
import com.gojek.trendingrepo.ViewModelProviderFactory
import javax.inject.Inject
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.gojek.trendingrepo.TrendingRepo
import com.gojek.trendingrepo.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),MainNavigator {

    @Inject
    lateinit var factory: ViewModelProviderFactory

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProviders.of(this,  factory).get(MainViewModel::class.java)
        mainViewModel.navigator = this

        val mViewDataBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mViewDataBinding.viewModel= mainViewModel

        mainViewModel.setDataToView()

    }


    override fun handleError(throwable: Throwable) {
        //
    }
}
