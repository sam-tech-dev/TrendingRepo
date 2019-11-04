package com.gojek.trendingrepo.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.gojek.trendingrepo.R
import com.gojek.trendingrepo.ViewModelProviderFactory
import com.gojek.trendingrepo.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(),MainNavigator,View.OnClickListener {

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

        setSupportActionBar(toolbar_top)
        supportActionBar?.setDisplayShowTitleEnabled(false);

        mainViewModel.setDataToView()

        bt_retry?.setOnClickListener(this)

        sfl_repos?.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)

        sfl_repos?.setOnRefreshListener({
            mainViewModel.fetchTrendingRepositories()
        })
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
          super.onCreateOptionsMenu(menu)
           menuInflater.inflate(R.menu.main_menu, menu)
            return  true
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_sort_by_stars->{
              mainViewModel.sortRepositoriesByStars()
            }

            R.id.menu_sort_by_name->{
              mainViewModel.sortRepositoriesByName()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {

        when(v?.id){

            R.id.bt_retry->{
                mainViewModel.setDataToView()
            }
        }
    }

    override fun handleError(throwable: Throwable) {
        //
    }

    override fun stopRefreshing() {
        if(sfl_repos?.isRefreshing!!){
            sfl_repos?.isRefreshing= false
        }
    }
}
