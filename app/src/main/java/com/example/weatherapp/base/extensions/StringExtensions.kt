package com.example.weatherapp.base.extensions

import java.text.SimpleDateFormat
import java.util.Locale


fun String?.safe() = this ?: ""

fun String.formatDateToHour(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("h a", Locale.getDefault())
    val date = inputFormat.parse(this)
    return outputFormat.format(date!!)
}
fun String.formatToPartialDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())
    val date = inputFormat.parse(this)
    return outputFormat.format(date!!)
}