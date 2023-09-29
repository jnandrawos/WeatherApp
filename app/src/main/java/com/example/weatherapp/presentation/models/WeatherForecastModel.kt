package com.example.weatherapp.presentation.models

import com.example.weatherapp.base.extensions.formatToPartialDate
import com.example.weatherapp.base.extensions.safe
import com.google.gson.annotations.SerializedName
import java.util.Locale.*


data class WeatherForecastModel(
    @SerializedName("cod") var cod: String? = null,
    @SerializedName("message") var message: Int? = null,
    @SerializedName("cnt") var cnt: Int? = null,
    @SerializedName("list") var list: ArrayList<WeatherResponseModel>? = null,
    @SerializedName("city") var city: CityModel? = null
) {
    fun mapToWeatherByDayModel(): List<WeatherByDayModel> {
        val groupedByDay = list?.groupingBy {
            it.dtTxt.safe().split(" ")[0]
        }?.eachCount().orEmpty()

        val result = ArrayList<WeatherByDayModel>()

        for ((day, _) in groupedByDay) {
            val weatherList = list?.filter { it.dtTxt.safe().split(" ")[0] == day }

            val weatherByDayModel =
                WeatherByDayModel(day.formatToPartialDate(), ArrayList(weatherList.orEmpty()))
            result.add(weatherByDayModel)
        }

        return result
    }
}




