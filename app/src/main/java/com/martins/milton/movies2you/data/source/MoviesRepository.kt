package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.DataResult
import com.martins.milton.movies2you.data.models.Genre
import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.models.SimilarMovies

interface MoviesRepository {
    suspend fun getMovie(): DataResult<Movie>
    suspend fun getSimilarMovies(): DataResult<SimilarMovies>
    suspend fun getAllGenres(): DataResult<List<Genre>>
}