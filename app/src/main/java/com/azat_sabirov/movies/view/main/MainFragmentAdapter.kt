/*
package com.azat_sabirov.movies.view.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azat_sabirov.movies.databinding.FragmentMainRecyclerItemBinding
import com.azat_sabirov.movies.model.Movie

class MainFragmentAdapter(
    private var isReleased: Boolean,
    private var onItemViewClickListener: MainFragment.OnItemViewClickListener?
) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var movieReleasedData: List<Movie> = listOf()
    private var movieExpectedData: List<Movie> = listOf()

    fun removeListener() {
        onItemViewClickListener = null
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setReleasedMovie(data: List<Movie>) {
        movieReleasedData = data
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setExpectedMovie(data: List<Movie>) {
        movieExpectedData = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val binding = FragmentMainRecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        if (isReleased) holder.bind(
            movieReleasedData[position], true
        ) else holder.bind(movieExpectedData[position], false)
    }

    override fun getItemCount(): Int {
        return if (isReleased) movieReleasedData.size else movieExpectedData.size
    }

    inner class MainViewHolder(private val binding: FragmentMainRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie, isReleased: Boolean) = with(binding) {
            posterIv.setImageResource(movie.poster)
            titleTv.text = movie.title
            yearTv.text = movie.year

            if (isReleased) {
                starIv.visibility = View.VISIBLE
                movieRatingTv.visibility = View.VISIBLE
                movieRatingTv.text = movie.rating_kinopoisk
            }

            itemView.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(movie)
            }
        }
    }
}*/
