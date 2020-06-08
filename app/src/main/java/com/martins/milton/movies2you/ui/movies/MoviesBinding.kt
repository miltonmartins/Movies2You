package com.martins.milton.movies2you.ui.movies

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.martins.milton.movies2you.data.models.Movie

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, url: String?) {
    val baseUrl = "https://image.tmdb.org/t/p/w300/"
    Glide.with(view.context).load("$baseUrl$url")
        .thumbnail()
        .centerCrop()
        .into(view)
}

@BindingAdapter("app:items")
fun setItems(listView: RecyclerView, items: List<Movie>) {
    (listView.adapter as MoviesAdapter).submitList(items)
}