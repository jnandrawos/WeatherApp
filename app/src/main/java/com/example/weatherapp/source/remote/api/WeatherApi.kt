package com.example.weatherapp.source.remote.api

import com.example.weatherapp.presentation.models.WeatherForecastModel
import com.example.weatherapp.presentation.models.WeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("lat") lat: Double? = null,
        @Query("lon") long: Double? = null,
        @Query("units") units: String = "metric"
    ): Response<WeatherResponseModel>

    @GET("forecast")
    suspend fun getForecastWeather(
        @Query("lat") lat: Double? = null,
        @Query("lon") long: Double? = null,
        @Query("units") units: String = "metric"
    ): Response<WeatherForecastModel>


}