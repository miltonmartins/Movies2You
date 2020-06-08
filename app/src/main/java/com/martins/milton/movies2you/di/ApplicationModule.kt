package com.martins.milton.movies2you.di

import com.martins.milton.movies2you.data.source.MoviesDataSource
import com.martins.milton.movies2you.data.source.MoviesDefaultRepository
import com.martins.milton.movies2you.data.source.MoviesRepository
import com.martins.milton.movies2you.data.source.remote.MoviesApi
import com.martins.milton.movies2you.data.source.remote.MoviesRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module(includes = [ApplicationModuleBinds::class, RetrofitModule::class])
object ApplicationModule {
    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class MoviesRemoteDataSource

    @Singleton
    @MoviesRemoteDataSource
    @Provides
    fun provideMoviesRemoteDataSource(
        moviesApi: MoviesApi,
        ioDispatcher: CoroutineDispatcher
    ): MoviesDataSource {
        return MoviesRemoteDataSource(moviesApi, ioDispatcher)
    }

    @Singleton
    @Provides
    fun provideIoDispatcher() = Dispatchers.IO
}

@Module
abstract class ApplicationModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: MoviesDefaultRepository): MoviesRepository
}
