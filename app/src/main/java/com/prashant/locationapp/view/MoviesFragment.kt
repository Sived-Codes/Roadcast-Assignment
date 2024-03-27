package com.prashant.locationapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.prashant.locationapp.adapter.MovieAdapter
import com.prashant.locationapp.databinding.FragmentMoviesBinding
import com.prashant.locationapp.model.MovieResponse
import com.prashant.locationapp.viewmodel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : Fragment() {
    private val movieViewModel: MovieViewModel by viewModels()
    private lateinit var movieAdapter: MovieAdapter

    private lateinit var bind: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        bind = FragmentMoviesBinding.inflate(inflater, container, false)
        setRecyclerview()
        movieViewModel.getMovie()
        movieViewModel.response.observe(requireActivity()) { response ->
            movieAdapter.setData(response as ArrayList<MovieResponse>)
            bind.progressBar.visibility =View.GONE
        }

        return bind.root
    }

    private fun setRecyclerview() {
        movieAdapter = MovieAdapter(requireContext(), ArrayList())
        bind.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = movieAdapter
        }
    }

}