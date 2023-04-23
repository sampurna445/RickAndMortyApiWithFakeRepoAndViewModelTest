package com.example.rickandmortyapi.data.model.episodes


import com.google.gson.annotations.SerializedName

data class EpisodesModel(
    @SerializedName("info")
    val info: InfoModel? = InfoModel(),
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)