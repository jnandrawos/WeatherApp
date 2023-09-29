package com.example.weatherapp.source.remote.service

import com.example.weatherapp.base.di.NetworkModule
import com.example.weatherapp.base.models.APIResponse
import com.example.weatherapp.base.models.Status
import com.example.weatherapp.presentation.models.WeatherForecastModel
import com.example.weatherapp.presentation.models.WeatherResponseModel
import com.example.weatherapp.source.remote.api.WeatherApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WeatherService @Inject constructor(private val weatherApi: WeatherApi) {
    private suspend fun getCurrentWeatherRemote(
        lat: Double,
        long: Double
    ): APIResponse<WeatherResponseModel> =
        NetworkModule().getResponse {
            weatherApi.getCurrentWeather(lat, long)
        }

    suspend fun
            getCurrentWeather(lat: Double, long: Double): Flow<APIResponse<WeatherResponseModel>> {
        return flow {
            emit(APIResponse.loading())
            val response =
                getCurrentWeatherRemote(lat, long)
            emit(response)
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(
                    APIResponse(
                        Status.ERROR,
                        data = null,
                        Exception(it),
                        it.message.toString()
                    )
                )
            }
    }

    private suspend fun getForecastWeatherRemote(
        lat: Double,
        long: Double
    ): APIResponse<WeatherForecastModel> =
        NetworkModule().getResponse {
            weatherApi.getForecastWeather(lat, long)
        }

    suspend fun
            getForecastWeather(lat: Double, long: Double): Flow<APIResponse<WeatherForecastModel>> {
        return flow {
            emit(APIResponse.loading())
            val response =
                getForecastWeatherRemote(lat, long)
            emit(response)
        }.flowOn(Dispatchers.IO)
            .catch {
                emit(
                    APIResponse(
                        Status.ERROR,
                        data = null,
                        Exception(it),
                        it.message.toString()
                    )
                )
            }
    }
}