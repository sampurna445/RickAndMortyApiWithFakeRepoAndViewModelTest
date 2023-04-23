package com.example.rickandmortyapi.ui.characters

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.characters.ResultModel
import com.example.rickandmortyapi.databinding.FragmentCharactersBinding
import com.example.rickandmortyapi.ui.characters.charactersDetails.CharactersDetailsViewModel

import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import kotlin.collections.ArrayList


@AndroidEntryPoint
class CharactersFragment : Fragment() {

    private var _binding: FragmentCharactersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private var charactersAdapter: CharactersAdapter? = null
    private val viewModel by viewModels<CharactersViewModel>()

    val sharedModel: CharactersDetailsViewModel by activityViewModels()
    lateinit var charmodel: CharactersModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentCharactersBinding.inflate(inflater, container, false)

        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText!!, (viewModel.chars.value?: ArrayList()) as List<ResultModel>)
                return true
            }
        })


        viewModel.characters.observe(viewLifecycleOwner) {
            charmodel = it
            setupUI(it, sharedModel)

        }

        viewModel.getCharacters()
        return binding.root
    }



      private  fun setupUI(
            characters: CharactersModel?,
            sharedModel: CharactersDetailsViewModel
        ) {

             charactersAdapter = CharactersAdapter(characters?.results)


            binding.rvCharacters.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = charactersAdapter

            }
            charactersAdapter!!.onItemClick = {
                sharedModel.getCharDetails(it)
                val bundle = Bundle()   //bundle is used for passing parameters
                bundle.putString("title", it.name?.uppercase())
                findNavController().navigate(
                    R.id.action_navigation_characters_to_fragment_characters_detail,
                    bundle
                )
            }


      }
    private fun filterList(query: String, characters: List<ResultModel>){
        query?.let {
            val filteredList = characters.filter { i -> (i.name)?.lowercase(Locale.ROOT)!!.contains(query) }
            if (filteredList.isEmpty()) {
                Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show()
            } else {
                charactersAdapter?.setFilteredList(ArrayList(filteredList))
            }
        }
    }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
    }
