package com.azat_sabirov.movies.model

data class Videocdn(
    val duration: Any,
    val quality: List<String>,
    val url: List<String>,
    val voice: List<String>
)