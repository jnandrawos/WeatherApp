package com.example.weatherapp.source.local

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object WeatherDatabaseMigrations {
    val MIGRATION_1_2 = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE weather_table ADD COLUMN username TEXT")
            database.execSQL("ALTER TABLE weather_table ADD COLUMN picture TEXT")
            database.execSQL("ALTER TABLE weather_table ADD COLUMN nationality TEXT")
        }
    }
}