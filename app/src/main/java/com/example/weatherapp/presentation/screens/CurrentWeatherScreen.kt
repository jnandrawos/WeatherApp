package com.example.weatherapp.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.weatherapp.R
import com.example.weatherapp.base.extensions.safe
import com.example.weatherapp.presentation.models.WeatherResponseModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CurrentWeatherScreen(
    weatherData: WeatherResponseModel?
) {
    val isPlaying by remember {
        mutableStateOf(true)
    }

    val speed by remember {
        mutableFloatStateOf(1f)
    }

    val composition by rememberLottieComposition(
        weatherData?.weatherModel?.firstOrNull()?.getWeatherAnimation()
            ?: LottieCompositionSpec.RawRes(R.raw.rain_and_sun)
    )
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = false

    )
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        weatherData?.let { weatherResponseModel ->
            Text(
                text = LocalDate.now().format(DateTimeFormatter.ofPattern("EEEE, dd MMMM")),
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth(),
                lineHeight = 35.sp,
                fontSize = 26.sp,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "${weatherResponseModel.name.safe()}\n${weatherResponseModel.sysModel?.country.safe()}",
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.fillMaxWidth(),
                lineHeight = 35.sp,
                fontSize = 26.sp,
                fontFamily = FontFamily.Cursive,
                textAlign = TextAlign.Center
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = if (weatherResponseModel.mainModel?.temp != null) "${weatherResponseModel.mainModel?.temp?.toInt()}C°" else "",
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically),
                    fontSize = 100.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = (-10).sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                )
                weatherResponseModel.weatherModel?.let {
                    LottieAnimation(
                        composition,
                        progress,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = if (weatherResponseModel.mainModel?.temp != null) "Min: ${weatherResponseModel.mainModel?.tempMin?.toInt()}C°" else "",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 16.sp,
                )
                Text(
                    text = if (weatherResponseModel.mainModel?.temp != null) "Max: ${weatherResponseModel.mainModel?.tempMax?.toInt()}C°" else "",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 16.sp,
                )
                Text(
                    text = if (weatherResponseModel.mainModel?.temp != null) "Humidity: ${weatherResponseModel.mainModel?.humidity?.toInt()}%" else "",
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 16.sp,
                )
            }
        }

    }
}