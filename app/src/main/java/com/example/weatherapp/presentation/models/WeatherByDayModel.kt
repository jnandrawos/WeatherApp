package com.example.weatherapp.presentation.models

data class WeatherByDayModel(
    var title: String? = null,
    var weather: ArrayList<WeatherResponseModel>? = null,
)
