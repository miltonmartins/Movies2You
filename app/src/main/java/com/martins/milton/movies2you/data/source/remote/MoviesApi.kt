package com.martins.milton.movies2you.data.source.remote

import com.martins.milton.movies2you.data.models.Genre
import com.martins.milton.movies2you.data.models.Movie
import com.martins.milton.movies2you.data.models.SimilarMovies
import retrofit2.http.GET

interface MoviesApi {
    @GET("movie/68735?api_key=e9ff598b6c6cf8694faf68a03f64006a")
    suspend fun getMovie(): Movie

    @GET("movie/68735/similar?api_key=e9ff598b6c6cf8694faf68a03f64006a")
    suspend fun getSimilarMovies(): SimilarMovies

    @GET("genre/movie/list?api_key=e9ff598b6c6cf8694faf68a03f64006a")
    suspend fun getAllGenres(): Map<String, List<Genre>>
}