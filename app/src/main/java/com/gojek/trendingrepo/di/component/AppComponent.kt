package com.gojek.trendingrepo.di.component

import android.app.Application
import com.gojek.trendingrepo.TrendingRepo
import com.gojek.trendingrepo.di.builder.ActivityBuilder
import com.gojek.trendingrepo.di.module.AppModule
import com.gojek.trendingrepo.di.module.ViewModelsModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/*AndroidSupportInjectionModule::class*/
@Singleton
@Component(modules = arrayOf(AndroidInjectionModule::class, AppModule::class, ViewModelsModule::class, ActivityBuilder::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: TrendingRepo)
}