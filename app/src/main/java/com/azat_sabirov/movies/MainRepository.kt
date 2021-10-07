package com.azat_sabirov.movies

import com.azat_sabirov.movies.data.MovieService
import com.azat_sabirov.movies.model.MovieDetailDTO

class MainRepository(private val movieService: MovieService) {
    fun getMovieDetail(token: String, movieId: Int): MovieDetailDTO =
        movieService.getMovieDetail(token, movieId)
}