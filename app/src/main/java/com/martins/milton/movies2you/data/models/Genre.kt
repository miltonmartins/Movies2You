package com.martins.milton.movies2you.data.models

import com.google.gson.annotations.SerializedName

data class Genre(
    @SerializedName("name") val name: String
)