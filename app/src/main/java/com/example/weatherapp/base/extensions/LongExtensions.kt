package com.example.weatherapp.base.extensions

import java.time.Duration
import java.time.Instant

fun Long.isTimestampOlderThan(minutes: Long): Boolean =
    (Instant.now().epochSecond - this) >= Duration.ofMinutes(minutes).seconds