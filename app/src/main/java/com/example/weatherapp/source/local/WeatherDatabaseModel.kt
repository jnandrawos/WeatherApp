package com.example.weatherapp.source.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant

@Entity(tableName = "weather_table")
data class WeatherDatabaseModel(
    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    @ColumnInfo(name = "timestamp") val timestamp: Long = Instant.now().epochSecond,
    @ColumnInfo(name = "weatherJsonModel") val weatherJsonModel: String? = null,
    @ColumnInfo(name = "username") val username: String? = null,
    @ColumnInfo(name = "picture") val picture: String? = null,
    @ColumnInfo(name = "nationality") val nationality: String? = null
)