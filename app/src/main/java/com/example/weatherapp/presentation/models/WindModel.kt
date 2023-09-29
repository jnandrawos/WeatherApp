package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName


data class WindModel(
    @SerializedName("speed") var speed: Double? = null,
    @SerializedName("deg") var deg: Int? = null,
    @SerializedName("gust") var gust: Double? = null
)