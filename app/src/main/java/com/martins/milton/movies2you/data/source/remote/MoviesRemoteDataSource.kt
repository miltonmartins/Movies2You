package com.martins.milton.movies2you.data.source.remote

import com.martins.milton.movies2you.data.models.Genre
import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.models.SimilarMovies
import com.martins.milton.movies2you.data.source.MoviesDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesRemoteDataSource constructor(
    private val moviesApi: MoviesApi,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MoviesDataSource {

    override suspend fun getMovie(): Movie = withContext(ioDispatcher) {
        return@withContext moviesApi.getMovie()
    }

    override suspend fun getSimilarMovies(): SimilarMovies = withContext(ioDispatcher) {
        return@withContext moviesApi.getSimilarMovies()
    }

    override suspend fun getAllGenres(): List<Genre> = withContext(ioDispatcher) {
        return@withContext moviesApi.getAllGenres()["genres"] ?: mutableListOf()
    }
}