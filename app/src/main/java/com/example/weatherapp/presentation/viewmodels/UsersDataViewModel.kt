package com.example.weatherapp.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.source.local.WeatherDatabaseModel
import com.example.weatherapp.source.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersDataViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {

    private val _databaseEntriesState = MutableStateFlow<ArrayList<WeatherDatabaseModel>?>(null)
    val databaseEntriesState = _databaseEntriesState.asStateFlow()
    fun getDatabaseEntries() {
        viewModelScope.launch {
            weatherRepository.getWeatherEntries().collect { list ->
                list?.let {
                    _databaseEntriesState.update {
                        list
                    }
                }
            }
        }
    }
}