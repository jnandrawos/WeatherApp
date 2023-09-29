package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName


data class RainModel(
    @SerializedName("1h") var onHour: Double? = null
)