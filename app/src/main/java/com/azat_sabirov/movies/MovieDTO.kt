package com.azat_sabirov.movies

import android.net.Uri

data class MovieDTO(val fact: FactDTO?)

data class FactDTO(
    val id_kinopoisk: Long?,
    val url: Uri,
    val title: String?,
    val description: String?,
    val rating_kinopoisk: String?,
    val duration: String?
)