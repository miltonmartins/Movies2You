package com.martins.milton.movies2you.di

import android.content.Context
import com.martins.milton.movies2you.Movies2YouApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        RetrofitModule::class,
        ApplicationModule::class,
        MoviesFragModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<Movies2YouApplication> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): ApplicationComponent
    }
}
