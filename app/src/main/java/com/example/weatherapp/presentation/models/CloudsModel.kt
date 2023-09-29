package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName


data class CloudsModel(
    @SerializedName("all") var all: Int? = null
)