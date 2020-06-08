package com.martins.milton.movies2you.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.source.MoviesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    private val _similarMovies = MutableLiveData<List<Movie>>()
    val similarMovies: LiveData<List<Movie>> = _similarMovies

    fun loadMovie() {
        viewModelScope.launch {
            val movie: Movie = moviesRepository.getMovie()
            _movie.value = movie
        }
    }

    private fun loadSimilarMovies() {
        viewModelScope.launch {

        }
    }
}