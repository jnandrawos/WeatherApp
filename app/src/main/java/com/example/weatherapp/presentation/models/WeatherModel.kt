package com.example.weatherapp.presentation.models

import com.airbnb.lottie.compose.LottieCompositionSpec
import com.example.weatherapp.R
import com.google.gson.annotations.SerializedName


data class WeatherModel(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("main") var main: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("icon") var icon: String? = null
) {
    fun getWeatherAnimation(): LottieCompositionSpec {
        return LottieCompositionSpec.RawRes(
            when (id) {
                in 200..299 -> R.raw.rain_storm_day
                in 300..399 -> if (icon?.last() == 'n') R.raw.rain_and_moon else R.raw.rain_and_sun
                in 500..599 -> if (icon?.last() == 'n') R.raw.rain_night else R.raw.rain_day
                in 600..699 -> R.raw.cloud_snow
                else -> if (icon?.last() == 'n') R.raw.clear_night else R.raw.sunny

            }
        )
    }
}