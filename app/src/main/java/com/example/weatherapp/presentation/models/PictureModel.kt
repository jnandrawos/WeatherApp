package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName

data class PictureModel(
    @SerializedName("large") var large: String? = null,
    @SerializedName("medium") var medium: String? = null,
    @SerializedName("thumbnail") var thumbnail: String? = null
)
