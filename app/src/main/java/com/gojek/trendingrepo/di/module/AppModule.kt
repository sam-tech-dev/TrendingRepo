package com.gojek.trendingrepo.di.module


import android.content.Context
import com.gojek.trendingrepo.TrendingRepo
import com.gojek.trendingrepo.di.annotations.ApplicationContext
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.gojek.trendingrepo.BuildConfig.BASE_URL
import com.gojek.trendingrepo.data.network.remote.ApiRequests
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor




@Module
class AppModule {

    @ApplicationContext
    @Provides
    internal  fun getApplicationContext(application: TrendingRepo) : Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    internal  fun getApplication() : TrendingRepo {
        return TrendingRepo.getInstance()
    }


    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @Singleton
    internal fun provideApiRequests(): ApiRequests {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        val gson = GsonBuilder().setLenient().create()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build().create(ApiRequests::class.java)
    }



  /*  @Provides
    internal fun provideScheduler(): SchedulerProvider{
        return AppSchedulerProvider()
    }*/

}
