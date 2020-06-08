package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.models.SimilarMovies
import com.martins.milton.movies2you.di.ApplicationModule.MoviesRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesDefaultRepository @Inject constructor(
    @MoviesRemoteDataSource val remoteDataSource: MoviesDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesRepository {
    override suspend fun getMovie(): Movie {
        return withContext(ioDispatcher) {
            return@withContext remoteDataSource.getMovie()
        }
    }

    override suspend fun getSimilarMovies(): SimilarMovies {
        return withContext(ioDispatcher) {
            return@withContext remoteDataSource.getSimilarMovies()
        }
    }
}