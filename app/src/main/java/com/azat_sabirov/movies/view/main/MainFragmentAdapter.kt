package com.azat_sabirov.movies.view.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azat_sabirov.movies.R
import com.azat_sabirov.movies.model.Movie

class MainFragmentAdapter(
    private var isReleased: Boolean,
    private var onItemViewClickListener: MainFragment.OnItemViewClickListener?
) :
    RecyclerView.Adapter<MainFragmentAdapter.MainViewHolder>() {

    private var movieReleasedData: List<Movie> = listOf()
    private var movieExpectedData: List<Movie> = listOf()

    fun removeListener(){
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
        return MainViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_main_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        if (isReleased) holder.bind(
            movieReleasedData[position], true
        ) else holder.bind(movieExpectedData[position], false)
    }

    override fun getItemCount(): Int {
        return if (isReleased) movieReleasedData.size else movieExpectedData.size
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(movie: Movie, isReleased: Boolean) {
            itemView.findViewById<ImageView>(R.id.poster_iv).setImageResource(movie.poster)
            itemView.findViewById<TextView>(R.id.title_tv).text = movie.title
            itemView.findViewById<TextView>(R.id.year_tv).text = movie.year

            if (isReleased) {
                itemView.findViewById<ImageView>(R.id.star_iv).visibility = View.VISIBLE
                itemView.findViewById<TextView>(R.id.rating_tv).visibility = View.VISIBLE
                itemView.findViewById<TextView>(R.id.rating_tv).text = movie.rating_kinopoisk
            }

            itemView.setOnClickListener {
                onItemViewClickListener?.onItemViewClick(movie)
            }
        }
    }
}