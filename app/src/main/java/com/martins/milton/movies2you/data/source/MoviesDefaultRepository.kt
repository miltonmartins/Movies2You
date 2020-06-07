package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.source.remote.MoviesRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MoviesDefaultRepository(
    val remoteDataSource: MoviesRemoteDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesRepository {
    override fun getMoviesByActor(): List<Movie> {
        TODO("Not yet implemented")
    }
}