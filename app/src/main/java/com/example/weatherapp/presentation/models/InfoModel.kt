package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName

data class InfoModel(
    @SerializedName("seed") var seed: String? = null,
    @SerializedName("results") var results: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("version") var version: String? = null
)
