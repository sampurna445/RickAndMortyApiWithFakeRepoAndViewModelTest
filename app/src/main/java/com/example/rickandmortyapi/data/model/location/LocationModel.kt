package com.example.rickandmortyapi.data.model.location


import com.google.gson.annotations.SerializedName

data class LocationModel(
    @SerializedName("info")
    val info: InfoModel? = InfoModel(),
    @SerializedName("results")
    val results: List<ResultModel?>? = listOf()
)