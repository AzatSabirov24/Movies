package com.azat_sabirov.movies.data

import com.azat_sabirov.movies.model.MovieDetailDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {
    @GET("/movie/{id}/token/{token}")
    fun getMovieDetail(
        @Path("token") token: String,
        @Path("id") id: Int,
        ) : MovieDetailDTO
}