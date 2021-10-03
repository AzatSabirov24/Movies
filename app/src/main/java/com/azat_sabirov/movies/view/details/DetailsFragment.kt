package com.azat_sabirov.movies.view.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.azat_sabirov.movies.databinding.FragmentDetailsBinding
import com.azat_sabirov.movies.model.Movie

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        val movie = arguments?.getParcelable<Movie>(BUNDLE_EXTRA)
        if (movie != null) {
            movieTitleTv.text = movie.title
            moviePosterIv.setImageResource(movie.poster)
            movieRatingTextTv.text = movie.rating_kinopoisk
            movieGenresTv.text = movie.genres.joinToString { it }
            movieDurationTv.text = movie.duration
            movieDescriptionTv.text = movie.description
        }
    }

    companion object {
        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}