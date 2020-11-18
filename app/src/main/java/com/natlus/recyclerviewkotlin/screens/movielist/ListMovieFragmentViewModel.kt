package com.natlus.recyclerviewkotlin.screens.movielist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natlus.recyclerviewkotlin.models.Movie

class ListMovieFragmentViewModel(private var listMovie: ArrayList<Movie>) : ViewModel() {
    private val listMovieMutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData(listMovie)
    val listMovieLiveData: LiveData<List<Movie>>
        get() = listMovieMutableLiveData

    fun addOneItem() {
        listMovie.add(
            Movie(
                movieTitle = "Judul Baru",
                movieDescription = "Deskripsi Item Baru",
                movieStatus = false
            )
        )
        listMovieMutableLiveData.value = listMovie
    }
}