package com.example.weatherapp.presentation.models

import com.google.gson.annotations.SerializedName


data class WeatherResponseModel(
    @SerializedName("coord") var coordModel: CoordModel? = null,
    @SerializedName("weather") var weatherModel: ArrayList<WeatherModel>? = null,
    @SerializedName("base") var base: String? = null,
    @SerializedName("main") var mainModel: MainModel? = null,
    @SerializedName("visibility") var visibility: Int? = null,
    @SerializedName("wind") var windModel: WindModel? = null,
    @SerializedName("rain") var rainModel: RainModel? = null,
    @SerializedName("clouds") var cloudsModel: CloudsModel? = null,
    @SerializedName("dt") var dt: Int? = null,
    @SerializedName("dt_txt") var dtTxt: String? = null,
    @SerializedName("sys") var sysModel: SysModel? = null,
    @SerializedName("timezone") var timezone: Int? = null,
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("cod") var cod: Int? = null
)