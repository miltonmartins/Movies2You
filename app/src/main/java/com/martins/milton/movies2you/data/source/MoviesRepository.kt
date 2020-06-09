package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.Genre
import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.models.SimilarMovies

interface MoviesRepository {
    suspend fun getMovie(): Movie
    suspend fun getSimilarMovies(): SimilarMovies
    suspend fun getAllGenres(): List<Genre>
}