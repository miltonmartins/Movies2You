package com.martins.milton.movies2you.ui.movies

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, url: String?) {
    val baseUrl = "https://image.tmdb.org/t/p/w300/"
    Glide.with(view.context).load("$baseUrl$url")
        .thumbnail()
        .centerCrop()
        .into(view)
}