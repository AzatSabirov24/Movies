/*
package com.azat_sabirov.movies.view.details


import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.azat_sabirov.movies.databinding.FragmentDetailsBinding
import com.azat_sabirov.movies.model.Movie
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

//Сайт кинопоиска  https://kinopoisk.cloud/docs

private const val YOUR_API_KEY = "8b90606f0f0d8b8137380db17db78c1f"

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieBundle: Movie

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: Movie()
        binding.mainView.visibility = View.GONE
        binding.loadingLayout.visibility = View.VISIBLE
        loadMovie()
    }
    */
/*(arguments?.getParcelable<Movie>(BUNDLE_EXTRA))?.apply {
            movieTitleTv.text = this.title
            moviePosterIv.setImageResource(this.poster)
            movieRatingTv.text = this.rating_kinopoisk
            movieGenresTv.text = this.genres.joinToString { it }
            movieDurationTv.text = this.duration
            movieDescriptionTv.text = this.description
        }*//*



     @RequiresApi(Build.VERSION_CODES.N)
     private fun loadMovie() {
         try {
             val uri =
                 URL("https://api.kinopoisk.cloud/movies/1143242/token/bf91fd8982ead6ab61aa0504004602e7")
             val handler = Handler()
             Thread {
                 lateinit var urlConnection: HttpsURLConnection
                 try {
                     urlConnection = uri.openConnection() as HttpsURLConnection
                     urlConnection.requestMethod = "GET"
                     urlConnection.addRequestProperty(
                         "X-kinopoisk-API-Key",
                         YOUR_API_KEY
                     )
                     urlConnection.readTimeout = 10000
                     val bufferedReader =
                         BufferedReader(InputStreamReader(urlConnection.inputStream))

                     val movieDTO: MovieDTO =
                         Gson().fromJson(getLines(bufferedReader), MovieDTO::class.java)
                     handler.post { displayMovie(movieDTO) }
                 } catch (e: Exception) {
                     Log.e("", "Fail connection", e)
                     e.printStackTrace()
                 } finally {
                     urlConnection.disconnect()
                 }
             }.start()
         } catch (e: MalformedURLException) {
             Log.e("", "Fail URI", e)
             e.printStackTrace()
         }
     }

     @RequiresApi(Build.VERSION_CODES.N)
     private fun getLines(reader: BufferedReader): String {
         return reader.lines().collect(Collectors.joining("\n"))
     }

     private fun displayMovie(movieDTO: MovieDTO) = with(binding) {
         mainView.visibility = View.VISIBLE
         loadingLayout.visibility = View.GONE

         movieTitleTv.text = movieDTO.fact?.title.toString()
         moviePosterIv.setImageURI(movieDTO.fact?.url)
         movieDescriptionTv.text = movieDTO.fact?.description.toString()
     }

    */
/*private fun loadMovie() {
        Thread {
            var connection: HttpURLConnection? = null
            try {
                connection =
                    URL("https://api.kinopoisk.cloud/movies/1143242/token/bf91fd8982ead6ab61aa0504004602e7").openConnection() as HttpURLConnection
                connection.requestMethod = "GET"
                connection.readTimeout = 10_000
                val reader = BufferedReader(InputStreamReader(connection.inputStream))
                val response = reader.readLines().joinToString()

            }finally {

            }
        }.start()
    }*//*


    companion object {
        const val BUNDLE_EXTRA = "movie"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}*/
