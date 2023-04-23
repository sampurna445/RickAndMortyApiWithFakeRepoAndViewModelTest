package com.example.rickandmortyapi.data.model.characters


import com.google.gson.annotations.SerializedName

data class OriginModel(
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("url")
    val url: String? = ""
)