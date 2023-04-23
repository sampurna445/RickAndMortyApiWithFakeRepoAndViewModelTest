package com.example.rickandmortyapi.ui.location


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapi.data.model.location.LocationModel
import com.example.rickandmortyapi.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationViewModel  @Inject constructor(
    val repository: Repository
) : ViewModel() {


    val locations: MutableLiveData<LocationModel> = MutableLiveData()
    val dataLoading = MutableLiveData(true)

    fun getLocations() {
        viewModelScope.launch {
            val repository = repository.getLocations()
            locations.postValue(repository)
        }
    }
}