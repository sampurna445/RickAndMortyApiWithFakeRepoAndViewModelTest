package com.example.rickandmortyapi.ui.characters.charactersDetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmortyapi.data.model.characters.ResultModel
import com.example.rickandmortyapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersDetailsViewModel @Inject constructor(
    val repository: Repository
): ViewModel() {
    private val _charDetails : MutableLiveData<ResultModel> = MutableLiveData()

    val charDetails: LiveData<ResultModel> = _charDetails

    fun getCharDetails(charDetails: ResultModel) {
        this._charDetails.value = charDetails
    }
}