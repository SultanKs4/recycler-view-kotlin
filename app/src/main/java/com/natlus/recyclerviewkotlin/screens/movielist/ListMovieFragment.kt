package com.natlus.recyclerviewkotlin.screens.movielist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.natlus.recyclerviewkotlin.R
import com.natlus.recyclerviewkotlin.databinding.FragmentListMovieBinding
import com.natlus.recyclerviewkotlin.models.Movie

class ListMovieFragment : Fragment() {
    private lateinit var binding: FragmentListMovieBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_movie, container, false)
        setupRvMovie()
        return binding.root
    }

    private fun setupRvMovie() {
        val recyclerView = binding.rvMovie
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager

        val movieList: ArrayList<Movie> = arrayListOf(
            Movie("Naga Bonar", "Filem Perjuangan Naga Bonar Melawan Penjajah Belanda", false),
            Movie(
                "Naga Bonar Jadi Dua",
                "Filem Perjuangan Naga Bonar dan Anaknya Melawan Penjajah Asing dan Aseng",
                false
            )
        )

        val adapter = MovieAdapter(movieList)
        recyclerView.adapter = adapter
    }
}