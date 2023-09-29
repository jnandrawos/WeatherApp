package com.example.weatherapp.presentation.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.base.extensions.isTimestampOlderThan
import com.example.weatherapp.base.models.Status
import com.example.weatherapp.base.utils.Converters
import com.example.weatherapp.presentation.models.WeatherForecastModel
import com.example.weatherapp.presentation.models.WeatherResponseModel
import com.example.weatherapp.source.local.WeatherDatabaseModel
import com.example.weatherapp.source.remote.service.WeatherService
import com.example.weatherapp.source.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherService: WeatherService,
    private val weatherRepository: WeatherRepository
) :
    ViewModel() {

    private var currentWeatherJob: Job? = null
    private var forecastWeatherJob: Job? = null
    private val _currentWeatherState =
        MutableStateFlow<WeatherResponseModel?>(null)
    private val _forecastWeatherState =
        MutableStateFlow<WeatherForecastModel?>(null)
    val currentWeatherState = _currentWeatherState.asStateFlow()
    val forecastWeatherState = _forecastWeatherState.asStateFlow()
    val weatherStatus: MutableState<Status?> = mutableStateOf(null)
    val forecastStatus: MutableState<Status?> = mutableStateOf(null)
    val wasDeleted: MutableState<Boolean> = mutableStateOf(false)

    fun getCurrentWeather(lat: Double, long: Double) {
        currentWeatherJob?.cancel("Job Cancelled")
        currentWeatherJob =
            viewModelScope.launch {
                weatherService.getCurrentWeather(lat, long).collect { result ->
                    _currentWeatherState.update { _ ->
                        result.data
                    }
                    weatherStatus.value = result.status
                    result.data?.let { updateWeatherDatabase(it) }
                }
            }
    }

    fun getForecastWeather(lat: Double, long: Double) {
        forecastWeatherJob?.cancel("Job Cancelled")
        forecastWeatherJob =
            viewModelScope.launch {
                weatherService.getForecastWeather(lat, long).collect { result ->
                    _forecastWeatherState.update { _ ->
                        result.data
                    }
                    forecastStatus.value = result.status
                }
            }
    }

    fun deleteAllData() {
        viewModelScope.launch {
            weatherRepository.deleteAllData().collect {
                wasDeleted.value = it
            }
        }
    }

    private fun updateWeatherDatabase(data: WeatherResponseModel) {
        viewModelScope.launch {
            weatherRepository.getLastWeatherEntry().collect {
                it?.timestamp?.let { timestamp ->
                    if (timestamp.isTimestampOlderThan(minutes = 5)) {
                        weatherRepository.insert(
                            WeatherDatabaseModel(
                                weatherJsonModel = Converters.setWeatherJson(
                                    data
                                )
                            )
                        )
                    }
                } ?: run {
                    weatherRepository.insert(
                        WeatherDatabaseModel(
                            weatherJsonModel = Converters.setWeatherJson(
                                data
                            )
                        )
                    )
                }
            }
        }
    }

}