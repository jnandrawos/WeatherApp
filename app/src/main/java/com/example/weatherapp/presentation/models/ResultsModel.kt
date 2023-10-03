package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName

data class ResultsModel(
    @SerializedName("name") var name: NameModel? = null,
    @SerializedName("picture") var picture: PictureModel? = null,
    @SerializedName("nat") var nat: String? = null

)
