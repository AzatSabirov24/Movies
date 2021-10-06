package com.azat_sabirov.movies.model

import android.os.Parcelable
import com.azat_sabirov.movies.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id_kinopoisk: Long = 1143242L,
    var title: String = "Джентльмены",
    val title_alternative: String = "The Gentlemen",
    val genres: List<String> = listOf("Боевик", "Комедия", "Криминал"),
    val description: String = "Талантливый выпускник Оксфорда, применив свой уникальный ум и невиданную дерзость, придумал нелегальную схему обогащения с использованием поместья обедневшей английской аристократии. Однако когда он решает продать свой бизнес влиятельному клану миллиардеров из США, на его пути встают не менее обаятельные, но жесткие джентльмены. Намечается обмен любезностями, который точно не обойдется без перестрелок и парочки несчастных случаев.",
    val poster: Int = R.drawable.poster_gentleman,
    val rating_kinopoisk: String = "8.5",
    val year: String = "2019",
    val duration: String = "113 мин",
    val directors: List<String> = listOf("Гай Ричи"),
    val countries: List<String> = listOf("США"),
    val fees_world: String = "$87528459",
    val age: String = "зрителям, достигшим 18 лет",
    val actors: List<String> = listOf(
        "Мэттью МакКонахи",
        "Чарли Ханнэм",
        "Генри Голдинг",
        "Хью Грант",
        "Мишель Докери",
        "Джереми Стронг",
        "Эдди Марсан",
        "Джейсон Вонг",
        "Колин Фаррелл",
        "Лайн Рени",
        "Василий Дахненко",
        "Сергей Смирнов",
        "Филипп Бледный",
        "Алексей Иващенко",
        "Татьяна Шитова"
    )
) : Parcelable

fun getReleasedMovie() = listOf(
    Movie(
        id_kinopoisk = 1143242L,
        title = "Джентльмены",
        poster = R.drawable.poster_gentleman,
        year = "2019",
        rating_kinopoisk = "8.5"
    ),
    Movie(
        title = "Человек-паук",
        poster = R.drawable.spider_man_poster,
        year = "2018",
        rating_kinopoisk = "7.5"
    ),
    Movie(
        title = "Веном",
        poster = R.drawable.venom_poster,
        year = "2018",
        rating_kinopoisk = "6.8"
    ),
    Movie(
        title = "Выживший",
        poster = R.drawable.revenant,
        year = "2015",
        rating_kinopoisk = "8.4"
    ),
    Movie(
        title = "Эмма",
        poster = R.drawable.emma_poster,
        year = "2013",
        rating_kinopoisk = "7.2"
    )
)

fun getExpectedMovie() = listOf(
    Movie(title = "Чудаки", poster = R.drawable.jackass_poster, year = "2022"),
    Movie(title = "Бэтмен", poster = R.drawable.batman_poster, year = "2022"),
    Movie(title = "Морбиус", poster = R.drawable.morbius_poster, year = "2022"),
    Movie(title = "Топ-Ган", poster = R.drawable.topgun_poster, year = "2022"),
    Movie(title = "Аватар 2", poster = R.drawable.avatar_poster, year = "2022")
)

