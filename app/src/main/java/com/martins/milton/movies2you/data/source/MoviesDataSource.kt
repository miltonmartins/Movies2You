package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.Movie

interface MoviesDataSource {
    suspend fun getMovie(): Movie
    suspend fun getSimilarMovies(): List<Movie>
}