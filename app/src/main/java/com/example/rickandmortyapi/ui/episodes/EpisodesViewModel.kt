package com.example.rickandmortyapi.ui.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.episodes.EpisodesModel
import com.example.rickandmortyapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EpisodesViewModel  @Inject constructor(
    val repository: Repository
) : ViewModel() {


    val episodes: MutableLiveData<EpisodesModel> = MutableLiveData()
    val dataLoading = MutableLiveData(true)

    fun getEpisodes() {
        viewModelScope.launch {
            val repository = repository.getEpisodes()
            episodes.postValue(repository)
        }
    }
}