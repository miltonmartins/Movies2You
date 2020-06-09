package com.martins.milton.movies2you.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.martins.milton.movies2you.data.models.Genre
import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.source.MoviesRepository
import com.martins.milton.movies2you.utils.NumberFormatUtil
import kotlinx.coroutines.launch
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val moviesRepository: MoviesRepository
) : ViewModel() {
    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> = _movie

    private val _similarMovies = MutableLiveData<List<Movie>>().apply { value = mutableListOf() }
    val similarMovies: LiveData<List<Movie>> = _similarMovies

    private val _allGenres = MutableLiveData<List<Genre>>().apply { value = mutableListOf() }

    fun start() {
        loadMovie()
        loadSimilarMovies()
        loadAllGenres()
    }

    private fun loadMovie() {
        viewModelScope.launch {
            val movie: Movie = moviesRepository.getMovie()
            _movie.value = movie
        }
    }

    private fun loadSimilarMovies() {
        viewModelScope.launch {
            val movies: List<Movie> = moviesRepository.getSimilarMovies().movies

            if (_allGenres.value?.isNotEmpty()!!) {
                movies.forEach {
                    it.genres =
                        it.genresIds.map { id -> _allGenres.value!!.first { genre -> genre.id == id } }
                }
            }

            _similarMovies.value = movies
        }
    }

    private fun loadAllGenres() {
        viewModelScope.launch {
            val genres: List<Genre> = moviesRepository.getAllGenres()

            _allGenres.value = genres
        }
    }

    fun getGenres(movie: Movie): String {
        return movie.genres.joinToString {
            it.name
        }
    }

    fun getPopularity(popularity: Double): String {
        val popularityViews: Int = popularity.toString().replace(".", "").toInt()

        return NumberFormatUtil.getFormattedNumber(popularityViews)
    }
}