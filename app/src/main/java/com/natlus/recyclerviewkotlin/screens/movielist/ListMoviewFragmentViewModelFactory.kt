package com.natlus.recyclerviewkotlin.screens.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.natlus.recyclerviewkotlin.models.Movie

class ListMoviewFragmentViewModelFactory(private var listMovie: ArrayList<Movie>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ListMovieFragmentViewModel::class.java)) {
            return ListMovieFragmentViewModel(listMovie = listMovie) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}