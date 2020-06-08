package com.martins.milton.movies2you.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import com.martins.milton.movies2you.R
import javax.inject.Inject
import com.martins.milton.movies2you.databinding.FragmentMoviesBinding

class MoviesFragment : DaggerFragment() {
    private lateinit var viewDataBinding: FragmentMoviesBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by viewModels<MoviesViewModel> { viewModelFactory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies, container, false)
        viewDataBinding = FragmentMoviesBinding.bind(view).apply {
            viewmodel = viewModel
        }
        viewDataBinding.lifecycleOwner = this.viewLifecycleOwner

        viewDataBinding.viewmodel?.loadMovie()
        viewDataBinding.viewmodel?.movie?.observe(this.viewLifecycleOwner, Observer {
            viewDataBinding.movie = it
        })

        return view
    }
}