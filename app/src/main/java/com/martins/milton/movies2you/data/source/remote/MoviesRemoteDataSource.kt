package com.martins.milton.movies2you.data.source.remote

import com.martins.milton.movies2you.data.models.DataResult
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

    override suspend fun getMovie(): DataResult<Movie> = withContext(ioDispatcher) {
        return@withContext try {
            DataResult.Success(moviesApi.getMovie())
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }

    override suspend fun getSimilarMovies(): DataResult<SimilarMovies> = withContext(ioDispatcher) {
        return@withContext try {
            DataResult.Success(moviesApi.getSimilarMovies())
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }

    override suspend fun getAllGenres(): DataResult<List<Genre>> = withContext(ioDispatcher) {
        return@withContext try {
            DataResult.Success(moviesApi.getAllGenres()["genres"] ?: mutableListOf())
        } catch (e: Exception) {
            DataResult.Error(e)
        }
    }
}