package com.example.weatherapp

import android.app.Application
import androidx.activity.ComponentActivity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class WeatherApp : Application() {
    lateinit var activity: ComponentActivity
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: WeatherApp
    }
}