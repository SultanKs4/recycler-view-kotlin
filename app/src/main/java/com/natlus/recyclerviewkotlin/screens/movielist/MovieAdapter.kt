package com.natlus.recyclerviewkotlin.screens.movielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natlus.recyclerviewkotlin.databinding.ItemMovieBinding
import com.natlus.recyclerviewkotlin.models.Movie

class MovieAdapter(movieList: List<Movie>? = arrayListOf()) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movieList = movieList
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class MovieViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie?) {
            binding.movie = movie
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemMovieBinding = ItemMovieBinding.inflate(layoutInflater, parent, false)
        return MovieViewHolder(itemMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieList?.get(position))
    }

    override fun getItemCount(): Int {
        return movieList?.size ?: 0
    }
}