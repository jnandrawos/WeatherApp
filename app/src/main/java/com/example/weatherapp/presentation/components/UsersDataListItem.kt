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
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.SupervisedUserCircle
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.weatherapp.base.extensions.safe
import com.example.weatherapp.base.utils.Converters.getWeatherJson
import com.example.weatherapp.source.local.WeatherDatabaseModel

@Composable
fun UsersDataListItem(weatherDatabaseModel: WeatherDatabaseModel) {
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
        Spacer(modifier = Modifier.width(25.dp))
        weatherDatabaseModel.picture?.let {
            AsyncImage(
                model = it,
                modifier = Modifier
                    .height(40.dp),
                contentDescription = null,
            )
        } ?: run {
            Icon(
                imageVector = Icons.Filled.SupervisedUserCircle, contentDescription = null,
                modifier = Modifier
                    .size(40.dp),
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .height(80.dp)
                .weight(1f),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = weatherDatabaseModel.username ?: "No Data Recorded",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = weatherDatabaseModel.nationality ?: "No Data Recorded",
                color = MaterialTheme.colorScheme.onPrimary,
                fontSize = 15.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        getWeatherJson(weatherDatabaseModel.weatherJsonModel.safe()).let { weatherResponseModel ->
            weatherResponseModel.mainModel?.let {
                Text(
                    text = if (it.temp != null) "${it.temp?.toInt()}°" else "",
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier = Modifier.height(80.dp), verticalArrangement = Arrangement.Center) {
                weatherResponseModel.mainModel?.let {
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
                Spacer(modifier = Modifier.width(10.dp))
                weatherResponseModel.cloudsModel?.let {
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
        }
        Spacer(modifier = Modifier.width(25.dp))
    }
}