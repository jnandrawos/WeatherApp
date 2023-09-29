package com.example.weatherapp.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.base.extensions.safe
import com.example.weatherapp.presentation.models.WeatherByDayModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WeatherForecastColumn(modifier: Modifier, data: List<WeatherByDayModel>) {
    LazyColumn(
        modifier = modifier
    ) {
        data.forEach { day ->
            stickyHeader {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Text(
                        text = day.title.safe(),
                        color = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier.fillMaxWidth(),
                        fontSize = 28.sp,
                        textAlign = TextAlign.Start
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
            itemsIndexed(day.weather.orEmpty()) { index, weatherData ->
                ForecastListItem(weatherData = weatherData)
                if (index < day.weather.orEmpty().size) Spacer(
                    modifier = Modifier.height(
                        20.dp
                    )
                )
            }
        }
    }
}