package com.example.rickandmortyapi.data.repository

import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.characters.ResultModel
import com.example.rickandmortyapi.data.model.episodes.EpisodesModel
import com.example.rickandmortyapi.data.model.location.LocationModel

class FakeRepository : Repository {
    private val charactersList = mutableListOf<CharactersModel>()
    private var shouldReturnNetworkError = false

    fun setShouldReturnNetworkError(value:Boolean){
        shouldReturnNetworkError = value
    }

    override suspend fun getCharacters(): CharactersModel {
        return this.charactersList[1]
    }

    override suspend fun getLocations(): LocationModel {
        TODO("Not yet implemented")
    }

    override suspend fun getEpisodes(): EpisodesModel {
        TODO("Not yet implemented")
    }
}