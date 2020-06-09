package com.martins.milton.movies2you.data.models

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Movie(
    @SerializedName("original_title") val title: String,
    @SerializedName("popularity") val popularity: Double,
    @SerializedName("vote_count") val likes: Int,
    @SerializedName("release_date") val releaseDate: Timestamp,
    @SerializedName("genres") var genres: List<Genre>,
    @Nullable @SerializedName("genre_ids") val genresIds: List<Int>,
    @SerializedName("poster_path") val poster: String
)