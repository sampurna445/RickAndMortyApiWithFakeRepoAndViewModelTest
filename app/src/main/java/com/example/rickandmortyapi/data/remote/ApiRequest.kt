package com.example.rickandmortyapi.data.remote

import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.location.LocationModel
import com.example.rickandmortyapi.data.model.episodes.EpisodesModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRequest {
    @GET(ApiDetails.Characters_ENDPOINT)
    suspend fun getCharacters(): CharactersModel
    @GET(ApiDetails.Episodes_ENDPOINT)
    suspend fun getEpisodes(): EpisodesModel
    @GET(ApiDetails.Location_ENDPOINT)
    suspend fun getLocations(): LocationModel


}