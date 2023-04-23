package com.example.rickandmortyapi.ui.characters.charactersDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import coil.load
import com.bumptech.glide.Glide
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.characters.ResultModel
import com.example.rickandmortyapi.databinding.FragmentCharactersBinding
import com.example.rickandmortyapi.databinding.FragmentChractersDetailBinding
import com.example.rickandmortyapi.ui.characters.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment : Fragment() {

    private var _binding: FragmentChractersDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    val sharedModel: CharactersDetailsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentChractersDetailBinding.inflate(inflater, container, false)
        sharedModel.charDetails.observe(viewLifecycleOwner) {
            binding.characterName.text = it.name
            binding.characterStatus.text = it.status
            binding.characterGender.text = it.gender
            binding.characterOrigin.text = it.origin?.name
            binding.characterSpecies.text = it.species
            binding.characterCreated.text = it.created
         //   binding.avtarImg.load(it.image)
            val imgView: ImageView = binding.avtarImg
            context?.let{ctx ->
                Glide.with(ctx).load(it.image).into(imgView)

            }

        }

        return binding.root
    }

    private fun setupUI(charDetails: List<ResultModel>) {


    }


}