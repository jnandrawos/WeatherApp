package com.example.weatherapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.base.extensions.formatDateToHour
import com.example.weatherapp.presentation.models.WeatherResponseModel

@Composable
fun ForecastListItem(weatherData: WeatherResponseModel?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.tertiary
                    )
                ), shape = RoundedCornerShape(25.dp)
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        weatherData?.weatherModel?.let {
            AsyncImage(
                model = LocalContext.current.getString(
                    R.string.weather_image_link2x,
                    it.firstOrNull()?.icon
                ),
                modifier = Modifier
                    .height(90.dp),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        weatherData?.mainModel?.let {
            Text(
                text = if (it.temp != null) "${it.temp?.toInt()}°" else "",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(20.dp))
        Column(modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.Center) {
            weatherData?.mainModel?.let {
                Icon(
                    imageVector = Icons.Filled.WaterDrop,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(15.dp)
                )
                Text(
                    text = "${it.humidity}%",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            weatherData?.cloudsModel?.let {
                Icon(
                    imageVector = Icons.Filled.Cloud,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(15.dp)
                )
                Text(
                    text = "${it.all}%",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        Spacer(modifier = Modifier.width(20.dp))
        weatherData?.dtTxt?.let {
            Column(
                modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    imageVector = Icons.Filled.AccessTime,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.size(30.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = it.formatDateToHour(),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}