package com.martins.milton.movies2you.data.models

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Movie(
    @SerializedName("original_title") val title: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("vote_count") val likes: Int,
    @SerializedName("release_date") val releaseDate: Timestamp,
    @SerializedName("genres") val genres: List<Genre>,
    @SerializedName("poster_path") val poster: String,
    val similarMovies: List<Movie>
)