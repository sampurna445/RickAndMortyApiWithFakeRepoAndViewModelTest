package com.example.rickandmortyapi.data.repository

import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.characters.ResultModel
import com.example.rickandmortyapi.data.model.location.LocationModel
import com.example.rickandmortyapi.data.model.episodes.EpisodesModel
import retrofit2.http.Query

interface Repository {
     suspend fun getCharacters(): CharactersModel

     suspend fun getLocations(): LocationModel
     suspend fun getEpisodes(): EpisodesModel



}