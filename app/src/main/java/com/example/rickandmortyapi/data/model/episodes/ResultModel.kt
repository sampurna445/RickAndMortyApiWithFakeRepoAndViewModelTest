package com.example.rickandmortyapi.data.model.episodes


import com.google.gson.annotations.SerializedName

data class ResultModel(
    @SerializedName("air_date")
    val airDate: String? = "",
    @SerializedName("characters")
    val characters: List<String?>? = listOf(),
    @SerializedName("created")
    val created: String? = "",
    @SerializedName("episode")
    val episode: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("url")
    val url: String? = ""
)