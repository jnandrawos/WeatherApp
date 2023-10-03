package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName

data class NameModel(
    @SerializedName("title") var title: String? = null,
    @SerializedName("first") var first: String? = null,
    @SerializedName("last") var last: String? = null
)
