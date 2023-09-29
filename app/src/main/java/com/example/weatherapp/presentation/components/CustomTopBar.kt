package com.example.weatherapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.WindPower
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weatherapp.R
import com.example.weatherapp.presentation.models.WeatherResponseModel

@Composable
fun CustomTopBar(weatherData: State<WeatherResponseModel?>, updateDrawerState: (() -> Unit)?) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = MaterialTheme.colorScheme.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(10.dp))
        Icon(
            imageVector = Icons.Filled.Menu,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    updateDrawerState?.invoke()
                }, contentDescription = null
        )
        Spacer(modifier = Modifier.width(15.dp))
        weatherData.value?.weatherModel?.let {
            AsyncImage(
                model = LocalContext.current.getString(
                    R.string.weather_image_link,
                    it.firstOrNull()?.icon
                ),
                modifier = Modifier.size(50.dp),
                contentDescription = null
            )
        }
        weatherData.value?.mainModel?.let {
            Text(
                text = if (it.temp != null) "${it.temp} C°" else "",
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        weatherData.value?.windModel?.let {
            Icon(
                imageVector = Icons.Rounded.WindPower,
                modifier = Modifier.size(30.dp),
                tint = MaterialTheme.colorScheme.onPrimary,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = if (it.speed != null) "${it.speed} Km/h" else "",
                color = MaterialTheme.colorScheme.onPrimary,
            )
        }
    }
}