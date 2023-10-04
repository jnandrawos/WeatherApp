package com.example.weatherapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.presentation.components.WeatherForecastColumn
import com.example.weatherapp.presentation.models.WeatherForecastModel

@Composable
fun ForecastWeatherScreen(forecastData: WeatherForecastModel? = WeatherForecastModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Text(
            text = stringResource(R.string.forecast_display_title),
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 48.sp,
            textAlign = TextAlign.Start
        )
        Spacer(
            modifier = Modifier
                .height(10.dp)
        )
        forecastData?.mapToWeatherByDayModel()?.let {
            WeatherForecastColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("WeatherForecastColumn")
                    .weight(1f), data = it
            )
        }
    }
}
