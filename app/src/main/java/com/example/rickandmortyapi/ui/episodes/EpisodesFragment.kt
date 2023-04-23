package com.example.rickandmortyapi.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.data.model.episodes.EpisodesModel
import com.example.rickandmortyapi.databinding.FragmentEpisodesBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class EpisodesFragment : Fragment() {

    private var _binding: FragmentEpisodesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<EpisodesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        viewModel.episodes.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getEpisodes()
        return binding.root
    }

    private fun setupUI(episodes: EpisodesModel?) {
        val episodesAdapter = EpisodesAdapter(episodes?.results)


        binding.rvEpisodes.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = episodesAdapter

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}