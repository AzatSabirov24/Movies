package com.azat_sabirov.movies.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.azat_sabirov.movies.R
import com.azat_sabirov.movies.databinding.FragmentMainBinding
import com.azat_sabirov.movies.model.Movie
import com.azat_sabirov.movies.view.details.DetailsFragment
import com.azat_sabirov.movies.viewModel.AppState
import com.azat_sabirov.movies.viewModel.MainViewModel

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val adapterReleased = MainFragmentAdapter(true, setAdapterClickListener())
    private val adapterExpected = MainFragmentAdapter(false, setAdapterClickListener())


    private fun setAdapterClickListener(): OnItemViewClickListener {
        return object : OnItemViewClickListener {
            override fun onItemViewClick(movie: Movie) {
                val manager = activity?.supportFragmentManager
                if (manager != null) {
                    val bundle = Bundle()
                    bundle.putParcelable(DetailsFragment.BUNDLE_EXTRA, movie)
                    manager.beginTransaction()
                        .add(R.id.container, DetailsFragment.newInstance(bundle))
                        .addToBackStack("")
                        .commitAllowingStateLoss()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, { renderData(it as AppState) })
        viewModel.getMovieFromLocalSource()
    }

    private fun initView() = with(binding) {
        releasedRcv.adapter = adapterReleased
        releasedRcv.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        expectedRcv.adapter = adapterExpected
        expectedRcv.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
    }

    private fun renderData(appState: AppState) = with(binding) {
        when (appState) {
            is AppState.Success -> {
                fragmentMainLoadingLayout.visibility = View.GONE
                adapterReleased.setReleasedMovie(appState.movieDataReleased)
                adapterExpected.setExpectedMovie(appState.movieDataExpected)
            }
            is AppState.Loading -> {
                fragmentMainLoadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                fragmentMainLoadingLayout.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        adapterExpected.removeListener()
        adapterReleased.removeListener()
        super.onDestroy()
    }

    interface OnItemViewClickListener {
        fun onItemViewClick(movie: Movie)
    }
}