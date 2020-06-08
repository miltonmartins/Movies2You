package com.martins.milton.movies2you.data.models

import com.google.gson.annotations.SerializedName

data class SimilarMovies(@SerializedName("results") val movies: List<Movie>)