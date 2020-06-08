package com.martins.milton.movies2you.data.source.remote

import com.martins.milton.movies2you.data.models.Movie
import retrofit2.http.GET

interface MoviesApi {
    @GET("68735?api_key=e9ff598b6c6cf8694faf68a03f64006a")
    suspend fun getMovie(): Movie

    @GET("68735/similar?api_key=e9ff598b6c6cf8694faf68a03f64006a")
    suspend fun getSimilarMovies(): List<Movie>
}