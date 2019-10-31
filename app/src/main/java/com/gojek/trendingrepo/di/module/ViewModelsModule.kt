package com.gojek.trendingrepo.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gojek.trendingrepo.ViewModelProviderFactory
import com.gojek.trendingrepo.ui.main.MainViewModel
import dagger.Binds
import dagger.multibindings.IntoMap
import dagger.Provides
import dagger.MapKey
import dagger.Module

import javax.inject.Provider

import kotlin.reflect.KClass


@Module
class ViewModelsModule {

    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    @MapKey
    internal annotation class ViewModelKey(val value: KClass<out ViewModel>)


     @Provides
     internal fun viewModelFactory(providerMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>): ViewModelProviderFactory {
         return ViewModelProviderFactory(providerMap)
     }

    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal fun provideMainViewModel(): ViewModel {
        return MainViewModel()
    }
}