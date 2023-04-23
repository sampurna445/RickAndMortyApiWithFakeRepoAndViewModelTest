package com.example.rickandmortyapi.data.repository

import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.location.LocationModel
import com.example.rickandmortyapi.data.model.episodes.EpisodesModel
import com.example.rickandmortyapi.data.remote.ApiRequest
import retrofit2.http.Query
import javax.inject.Inject


 class RepositoryImpl @Inject constructor(
    val apiRequest: ApiRequest
):Repository {

    override suspend fun getCharacters(): CharactersModel = apiRequest.getCharacters()

    override suspend fun getLocations(): LocationModel = apiRequest.getLocations()
   override suspend fun getEpisodes(): EpisodesModel = apiRequest.getEpisodes()



}