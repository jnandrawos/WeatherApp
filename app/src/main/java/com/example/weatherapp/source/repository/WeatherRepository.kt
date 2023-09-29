package com.example.weatherapp.source.repository

import com.example.weatherapp.source.local.WeatherDao
import com.example.weatherapp.source.local.WeatherDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherDao: WeatherDao) {
    suspend fun insert(weatherDatabaseModel: WeatherDatabaseModel) = withContext(Dispatchers.IO) {
        weatherDao.insertWeatherEntry(weatherDatabaseModel)
    }

    fun getLastWeatherEntry(): Flow<WeatherDatabaseModel?> = flow {
        val weatherEntry = weatherDao.getLastWeatherEntry()
        emit(weatherEntry)
    }.flowOn(Dispatchers.IO)

    fun deleteAllData() = flow {
        weatherDao.deleteAllData()
        emit(true)
    }.flowOn(Dispatchers.IO).catch {
        emit(false)
    }
}