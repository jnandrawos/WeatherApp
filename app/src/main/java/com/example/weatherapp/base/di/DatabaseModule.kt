package com.example.weatherapp.base.di

import android.content.Context
import androidx.room.Room
import com.example.weatherapp.source.local.WeatherDao
import com.example.weatherapp.source.local.WeatherDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun providesUsersDao(weatherDatabase: WeatherDatabase): WeatherDao =
        weatherDatabase.weatherDao()

    @Provides
    @Singleton
    fun providesUsersDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            "weather db"
        )
            .fallbackToDestructiveMigration()
            .build()
}