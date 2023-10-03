package com.example.weatherapp.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_table ORDER BY timestamp DESC LIMIT 1")
    fun getLastWeatherEntry(): WeatherDatabaseModel

    @Query("SELECT * FROM weather_table")
    fun getWeatherEntries(): List<WeatherDatabaseModel>

    @Insert
    suspend fun insertWeatherEntry(transactionModel: WeatherDatabaseModel)

    @Query("DELETE FROM weather_table")
    fun deleteAllData()
}