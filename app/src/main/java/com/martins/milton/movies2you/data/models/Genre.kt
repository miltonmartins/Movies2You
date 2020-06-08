package com.martins.milton.movies2you.data.models

import androidx.annotation.Nullable
import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("name") val name: String,
    @Nullable @SerializedName("genre_ids") val genresIds: List<String>
)