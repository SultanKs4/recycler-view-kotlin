package com.natlus.recyclerviewkotlin.screens.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.natlus.recyclerviewkotlin.R
import com.natlus.recyclerviewkotlin.databinding.FragmentListMovieBinding
import com.natlus.recyclerviewkotlin.models.Movie

class ListMovieFragment : Fragment() {
    private lateinit var binding: FragmentListMovieBinding
    private lateinit var viewModel: ListMovieFragmentViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val movieList: ArrayList<Movie> = arrayListOf(
            Movie("Naga Bonar", "Filem Perjuangan Naga Bonar Melawan Penjajah Belanda", false),
            Movie(
                "Naga Bonar Jadi Dua",
                "Filem Perjuangan Naga Bonar dan Anaknya Melawan Penjajah Asing dan Aseng",
                false
            )
        )
        viewModel =
            ViewModelProvider(this, ListMoviewFragmentViewModelFactory(listMovie = movieList)).get(
                ListMovieFragmentViewModel::class.java
            )
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_movie, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRvMovie()
    }

    private fun setupRvMovie() {
        val recyclerView = binding.rvMovie
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = MovieAdapter()
        recyclerView.adapter = adapter
        viewModel.listMovieLiveData.observe(viewLifecycleOwner, { value ->
            adapter.movieList = value
        })
    }
}