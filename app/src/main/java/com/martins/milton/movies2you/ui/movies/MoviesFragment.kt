package com.martins.milton.movies2you.ui.movies

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.martins.milton.movies2you.R
import com.martins.milton.movies2you.databinding.FragmentMoviesBinding
import com.martins.milton.movies2you.utils.ConnectUtil
import dagger.android.support.DaggerFragment
import javax.inject.Inject


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
        viewDataBinding.viewmodel?.movie?.observe(this.viewLifecycleOwner, Observer {
            viewDataBinding.movie = it
        })

        setupAdapter()
        setupClickListeners()
        checkConnection()

        return view
    }

    private fun checkConnection() {
        when(ConnectUtil.isConnected(requireContext())) {
            true -> {
                viewDataBinding.buttonTryAgain.visibility = View.GONE
                viewDataBinding.viewmodel?.start()
            }
            else -> {
                Toast.makeText(context, getString(R.string.no_connection), Toast.LENGTH_LONG).show()
                viewDataBinding.buttonTryAgain.visibility = View.VISIBLE
            }
        }
    }

    private fun setupClickListeners() {
        viewDataBinding.imageLiked.setOnClickListener {
            if (it.tag == R.drawable.ic_favorite) {
                viewDataBinding.imageLiked.setImageResource(R.drawable.ic_favorite_disabled)
                viewDataBinding.imageLiked.tag = R.drawable.ic_favorite_disabled
            } else {
                viewDataBinding.imageLiked.setImageResource(R.drawable.ic_favorite)
                viewDataBinding.imageLiked.tag = R.drawable.ic_favorite
            }
        }

        viewDataBinding.buttonTryAgain.setOnClickListener {
            checkConnection()
        }

        viewDataBinding.buttonBack.setOnClickListener {
            activity?.finish()
        }
    }

    private fun setupAdapter() {
        viewDataBinding.rvMovies.adapter = MoviesAdapter(viewModel)
    }
}