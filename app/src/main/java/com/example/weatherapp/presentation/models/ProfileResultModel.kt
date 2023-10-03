package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName

data class ProfileResultModel(
    @SerializedName("results")
    var results: ArrayList<ResultsModel>? = null,
    @SerializedName("info")
    var info: InfoModel? = null

)