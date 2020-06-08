package com.martins.milton.movies2you.di

import androidx.lifecycle.ViewModel
import com.martins.milton.movies2you.ui.movies.MoviesFragment
import com.martins.milton.movies2you.ui.movies.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class MoviesFragModule {

    @ContributesAndroidInjector(modules = [
        ViewModelBuilder::class
    ])
    internal abstract fun moviesFragment(): MoviesFragment

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindViewModel(viewmodel: MoviesViewModel): ViewModel
}
