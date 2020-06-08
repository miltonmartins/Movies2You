package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.models.SimilarMovies

interface MoviesDataSource {
    suspend fun getMovie(): Movie
    suspend fun getSimilarMovies(): SimilarMovies
}