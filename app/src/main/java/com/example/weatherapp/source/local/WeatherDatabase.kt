package com.example.weatherapp.source.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WeatherDatabaseModel::class], version = WeatherDatabase.DB_VERSION)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        const val DB_VERSION = 1
    }
}