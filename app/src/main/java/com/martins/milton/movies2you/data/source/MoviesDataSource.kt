package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.Movie

interface MoviesDataSource {
    fun getMoviesByActor(): List<Movie>
}