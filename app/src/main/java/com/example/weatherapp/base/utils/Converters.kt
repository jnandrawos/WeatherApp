package com.example.weatherapp.base.utils

import com.example.weatherapp.presentation.models.WeatherResponseModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Converters {

    inline fun <reified T> T.toJson(): String = Gson().toJson(this)

    inline fun <reified T> String.toObject(): T = Gson().fromJson(this, T::class.java)
    fun setWeatherJson(result: WeatherResponseModel): String {
        val gson = Gson()
        return gson.toJson(result)
    }

    fun getWeatherJson(result: String): WeatherResponseModel {
        val gson = Gson()
        return gson.fromJson(
            result, object : TypeToken<WeatherResponseModel>() {}.type
        )
    }

}

