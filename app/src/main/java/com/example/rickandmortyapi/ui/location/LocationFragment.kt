package com.example.rickandmortyapi.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.data.model.location.LocationModel
import com.example.rickandmortyapi.databinding.FragmentLocationBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class LocationFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<LocationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        viewModel.locations.observe(viewLifecycleOwner) {
            setupUI(it)
        }
        viewModel.getLocations()
        return binding.root
    }

    private fun setupUI(locations: LocationModel?) {
        val locationsAdapter = LocationsAdapter(locations?.results)


        binding.rvLocation.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = locationsAdapter

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}