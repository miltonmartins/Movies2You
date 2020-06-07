package com.martins.milton.movies2you.data.source

import com.martins.milton.movies2you.data.models.Movie

interface MoviesRepository {
    fun getMoviesByActor(): List<Movie>
}