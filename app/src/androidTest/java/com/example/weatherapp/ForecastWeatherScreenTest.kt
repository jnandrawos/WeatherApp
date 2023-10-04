package com.example.weatherapp

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.weatherapp.base.utils.Converters
import com.example.weatherapp.presentation.screens.ForecastWeatherScreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)

class ForecastWeatherScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun forecastWeatherScreen_displaysTitle() {
        composeTestRule.setContent {
            ForecastWeatherScreen(forecastData = null)
        }

        composeTestRule
            .onNodeWithText("Forecast")
            .assertExists()
    }

    @Test
    fun forecastWeatherScreen_displaysWeatherData() {
        val forecastData = Converters.getForecastJson(
            "{ \"cod\": \"200\", \"message\": 0, \"cnt\": 40, \"list\": [ { \"dt\": 1696410000, \"main\": { \"temp\": 17.5, \"feels_like\": 17.03, \"temp_min\": 17.5, \"temp_max\": 18.28, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1013, \"humidity\": 66, \"temp_kf\": -0.78 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.52, \"deg\": 9, \"gust\": 0.72 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-04 09:00:00\" }, { \"dt\": 1696420800, \"main\": { \"temp\": 17.66, \"feels_like\": 17.1, \"temp_min\": 17.66, \"temp_max\": 17.94, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1013, \"humidity\": 62, \"temp_kf\": -0.28 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.52, \"deg\": 74, \"gust\": 0.76 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-04 12:00:00\" }, { \"dt\": 1696431600, \"main\": { \"temp\": 18.63, \"feels_like\": 17.96, \"temp_min\": 18.63, \"temp_max\": 18.63, \"pressure\": 1014, \"sea_level\": 1014, \"grnd_level\": 1014, \"humidity\": 54, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.81, \"deg\": 86, \"gust\": 0.88 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-04 15:00:00\" }, { \"dt\": 1696442400, \"main\": { \"temp\": 25.66, \"feels_like\": 25.2, \"temp_min\": 25.66, \"temp_max\": 25.66, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1014, \"humidity\": 35, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.87, \"deg\": 13, \"gust\": 1.48 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-04 18:00:00\" }, { \"dt\": 1696453200, \"main\": { \"temp\": 29.35, \"feels_like\": 28.05, \"temp_min\": 29.35, \"temp_max\": 29.35, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1013, \"humidity\": 28, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.66, \"deg\": 339, \"gust\": 1.72 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-04 21:00:00\" }, { \"dt\": 1696464000, \"main\": { \"temp\": 29.34, \"feels_like\": 28.04, \"temp_min\": 29.34, \"temp_max\": 29.34, \"pressure\": 1012, \"sea_level\": 1012, \"grnd_level\": 1012, \"humidity\": 28, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 2.28, \"deg\": 315, \"gust\": 2.2 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-05 00:00:00\" }, { \"dt\": 1696474800, \"main\": { \"temp\": 23.36, \"feels_like\": 22.85, \"temp_min\": 23.36, \"temp_max\": 23.36, \"pressure\": 1014, \"sea_level\": 1014, \"grnd_level\": 1013, \"humidity\": 42, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.33, \"deg\": 291, \"gust\": 2.16 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-05 03:00:00\" }, { \"dt\": 1696485600, \"main\": { \"temp\": 21.51, \"feels_like\": 20.94, \"temp_min\": 21.51, \"temp_max\": 21.51, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 47, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.32, \"deg\": 319, \"gust\": 0.83 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-05 06:00:00\" }, { \"dt\": 1696496400, \"main\": { \"temp\": 20.74, \"feels_like\": 20.1, \"temp_min\": 20.74, \"temp_max\": 20.74, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 47, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.07, \"deg\": 144, \"gust\": 1.18 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-05 09:00:00\" }, { \"dt\": 1696507200, \"main\": { \"temp\": 20.2, \"feels_like\": 19.5, \"temp_min\": 20.2, \"temp_max\": 20.2, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 47, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.01, \"deg\": 122, \"gust\": 1.11 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-05 12:00:00\" }, { \"dt\": 1696518000, \"main\": { \"temp\": 20.93, \"feels_like\": 20.28, \"temp_min\": 20.93, \"temp_max\": 20.93, \"pressure\": 1016, \"sea_level\": 1016, \"grnd_level\": 1015, \"humidity\": 46, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.61, \"deg\": 99, \"gust\": 0.74 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-05 15:00:00\" }, { \"dt\": 1696528800, \"main\": { \"temp\": 28.2, \"feels_like\": 27.24, \"temp_min\": 28.2, \"temp_max\": 28.2, \"pressure\": 1016, \"sea_level\": 1016, \"grnd_level\": 1016, \"humidity\": 30, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.93, \"deg\": 350, \"gust\": 1.23 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-05 18:00:00\" }, { \"dt\": 1696539600, \"main\": { \"temp\": 31.71, \"feels_like\": 29.95, \"temp_min\": 31.71, \"temp_max\": 31.71, \"pressure\": 1014, \"sea_level\": 1014, \"grnd_level\": 1014, \"humidity\": 24, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.97, \"deg\": 324, \"gust\": 1.85 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-05 21:00:00\" }, { \"dt\": 1696550400, \"main\": { \"temp\": 30.69, \"feels_like\": 29.05, \"temp_min\": 30.69, \"temp_max\": 30.69, \"pressure\": 1014, \"sea_level\": 1014, \"grnd_level\": 1013, \"humidity\": 25, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 3.48, \"deg\": 315, \"gust\": 4.31 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-06 00:00:00\" }, { \"dt\": 1696561200, \"main\": { \"temp\": 23.98, \"feels_like\": 23.45, \"temp_min\": 23.98, \"temp_max\": 23.98, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 39, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.72, \"deg\": 312, \"gust\": 3.12 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-06 03:00:00\" }, { \"dt\": 1696572000, \"main\": { \"temp\": 22.16, \"feels_like\": 21.55, \"temp_min\": 22.16, \"temp_max\": 22.16, \"pressure\": 1016, \"sea_level\": 1016, \"grnd_level\": 1015, \"humidity\": 43, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.39, \"deg\": 291, \"gust\": 0.86 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-06 06:00:00\" }, { \"dt\": 1696582800, \"main\": { \"temp\": 21.28, \"feels_like\": 20.59, \"temp_min\": 21.28, \"temp_max\": 21.28, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 43, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.22, \"deg\": 151, \"gust\": 0.77 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-06 09:00:00\" }, { \"dt\": 1696593600, \"main\": { \"temp\": 20.61, \"feels_like\": 19.85, \"temp_min\": 20.61, \"temp_max\": 20.61, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 43, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.14, \"deg\": 116, \"gust\": 0.74 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-06 12:00:00\" }, { \"dt\": 1696604400, \"main\": { \"temp\": 21.1, \"feels_like\": 20.36, \"temp_min\": 21.1, \"temp_max\": 21.1, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 42, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.3, \"deg\": 32, \"gust\": 0.5 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-06 15:00:00\" }, { \"dt\": 1696615200, \"main\": { \"temp\": 28.27, \"feels_like\": 27.16, \"temp_min\": 28.27, \"temp_max\": 28.27, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1014, \"humidity\": 27, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.26, \"deg\": 340, \"gust\": 1.58 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-06 18:00:00\" }, { \"dt\": 1696626000, \"main\": { \"temp\": 31.67, \"feels_like\": 29.78, \"temp_min\": 31.67, \"temp_max\": 31.67, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 22, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 2.52, \"deg\": 319, \"gust\": 2.65 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-06 21:00:00\" }, { \"dt\": 1696636800, \"main\": { \"temp\": 30.08, \"feels_like\": 28.46, \"temp_min\": 30.08, \"temp_max\": 30.08, \"pressure\": 1012, \"sea_level\": 1012, \"grnd_level\": 1011, \"humidity\": 24, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 3.27, \"deg\": 315, \"gust\": 4.39 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-07 00:00:00\" }, { \"dt\": 1696647600, \"main\": { \"temp\": 23.18, \"feels_like\": 22.52, \"temp_min\": 23.18, \"temp_max\": 23.18, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 37, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.78, \"deg\": 308, \"gust\": 3.04 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-07 03:00:00\" }, { \"dt\": 1696658400, \"main\": { \"temp\": 21.31, \"feels_like\": 20.57, \"temp_min\": 21.31, \"temp_max\": 21.31, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 41, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.66, \"deg\": 291, \"gust\": 1.21 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-07 06:00:00\" }, { \"dt\": 1696669200, \"main\": { \"temp\": 20.57, \"feels_like\": 19.75, \"temp_min\": 20.57, \"temp_max\": 20.57, \"pressure\": 1012, \"sea_level\": 1012, \"grnd_level\": 1012, \"humidity\": 41, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.14, \"deg\": 242, \"gust\": 0.77 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-07 09:00:00\" }, { \"dt\": 1696680000, \"main\": { \"temp\": 19.86, \"feels_like\": 19, \"temp_min\": 19.86, \"temp_max\": 19.86, \"pressure\": 1012, \"sea_level\": 1012, \"grnd_level\": 1012, \"humidity\": 42, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.47, \"deg\": 312, \"gust\": 0.78 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-07 12:00:00\" }, { \"dt\": 1696690800, \"main\": { \"temp\": 20.34, \"feels_like\": 19.53, \"temp_min\": 20.34, \"temp_max\": 20.34, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 42, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.38, \"deg\": 323, \"gust\": 0.59 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-07 15:00:00\" }, { \"dt\": 1696701600, \"main\": { \"temp\": 27.17, \"feels_like\": 26.45, \"temp_min\": 27.17, \"temp_max\": 27.17, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 28, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.76, \"deg\": 329, \"gust\": 2.01 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-07 18:00:00\" }, { \"dt\": 1696712400, \"main\": { \"temp\": 30.41, \"feels_like\": 28.65, \"temp_min\": 30.41, \"temp_max\": 30.41, \"pressure\": 1011, \"sea_level\": 1011, \"grnd_level\": 1011, \"humidity\": 22, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 2.95, \"deg\": 315, \"gust\": 3.17 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-07 21:00:00\" }, { \"dt\": 1696723200, \"main\": { \"temp\": 28.14, \"feels_like\": 27.03, \"temp_min\": 28.14, \"temp_max\": 28.14, \"pressure\": 1011, \"sea_level\": 1011, \"grnd_level\": 1010, \"humidity\": 26, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 3.62, \"deg\": 314, \"gust\": 4.7 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-08 00:00:00\" }, { \"dt\": 1696734000, \"main\": { \"temp\": 21.15, \"feels_like\": 20.55, \"temp_min\": 21.15, \"temp_max\": 21.15, \"pressure\": 1012, \"sea_level\": 1012, \"grnd_level\": 1012, \"humidity\": 47, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.98, \"deg\": 305, \"gust\": 3.11 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-08 03:00:00\" }, { \"dt\": 1696744800, \"main\": { \"temp\": 19.58, \"feels_like\": 18.93, \"temp_min\": 19.58, \"temp_max\": 19.58, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 51, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.86, \"deg\": 292, \"gust\": 1.53 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-08 06:00:00\" }, { \"dt\": 1696755600, \"main\": { \"temp\": 18.72, \"feels_like\": 18.03, \"temp_min\": 18.72, \"temp_max\": 18.72, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 53, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.85, \"deg\": 311, \"gust\": 1.42 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-08 09:00:00\" }, { \"dt\": 1696766400, \"main\": { \"temp\": 17.65, \"feels_like\": 16.96, \"temp_min\": 17.65, \"temp_max\": 17.65, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 57, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01n\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.84, \"deg\": 309, \"gust\": 1.24 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-08 12:00:00\" }, { \"dt\": 1696777200, \"main\": { \"temp\": 17.66, \"feels_like\": 17.07, \"temp_min\": 17.66, \"temp_max\": 17.66, \"pressure\": 1014, \"sea_level\": 1014, \"grnd_level\": 1013, \"humidity\": 61, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 0.8, \"deg\": 308, \"gust\": 1.42 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-08 15:00:00\" }, { \"dt\": 1696788000, \"main\": { \"temp\": 24.64, \"feels_like\": 24.13, \"temp_min\": 24.64, \"temp_max\": 24.64, \"pressure\": 1014, \"sea_level\": 1014, \"grnd_level\": 1014, \"humidity\": 37, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 0 }, \"wind\": { \"speed\": 1.94, \"deg\": 320, \"gust\": 2.36 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-08 18:00:00\" }, { \"dt\": 1696798800, \"main\": { \"temp\": 27.74, \"feels_like\": 26.83, \"temp_min\": 27.74, \"temp_max\": 27.74, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1013, \"humidity\": 28, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 800, \"main\": \"Clear\", \"description\": \"clear sky\", \"icon\": \"01d\" } ], \"clouds\": { \"all\": 10 }, \"wind\": { \"speed\": 3.32, \"deg\": 314, \"gust\": 3.66 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-08 21:00:00\" }, { \"dt\": 1696809600, \"main\": { \"temp\": 23.87, \"feels_like\": 23.33, \"temp_min\": 23.87, \"temp_max\": 23.87, \"pressure\": 1013, \"sea_level\": 1013, \"grnd_level\": 1012, \"humidity\": 39, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 802, \"main\": \"Clouds\", \"description\": \"scattered clouds\", \"icon\": \"03d\" } ], \"clouds\": { \"all\": 47 }, \"wind\": { \"speed\": 3.31, \"deg\": 316, \"gust\": 4.12 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"d\" }, \"dt_txt\": \"2023-10-09 00:00:00\" }, { \"dt\": 1696820400, \"main\": { \"temp\": 18.63, \"feels_like\": 18.06, \"temp_min\": 18.63, \"temp_max\": 18.63, \"pressure\": 1014, \"sea_level\": 1014, \"grnd_level\": 1014, \"humidity\": 58, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 804, \"main\": \"Clouds\", \"description\": \"overcast clouds\", \"icon\": \"04n\" } ], \"clouds\": { \"all\": 96 }, \"wind\": { \"speed\": 2.11, \"deg\": 307, \"gust\": 2.94 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-09 03:00:00\" }, { \"dt\": 1696831200, \"main\": { \"temp\": 16.75, \"feels_like\": 16.23, \"temp_min\": 16.75, \"temp_max\": 16.75, \"pressure\": 1015, \"sea_level\": 1015, \"grnd_level\": 1015, \"humidity\": 67, \"temp_kf\": 0 }, \"weather\": [ { \"id\": 804, \"main\": \"Clouds\", \"description\": \"overcast clouds\", \"icon\": \"04n\" } ], \"clouds\": { \"all\": 95 }, \"wind\": { \"speed\": 1.56, \"deg\": 300, \"gust\": 2.47 }, \"visibility\": 10000, \"pop\": 0, \"sys\": { \"pod\": \"n\" }, \"dt_txt\": \"2023-10-09 06:00:00\" } ], \"city\": { \"id\": 5375480, \"name\": \"Mountain View\", \"coord\": { \"lat\": 37.422, \"lon\": -122.084 }, \"country\": \"US\", \"population\": 74066, \"timezone\": -25200, \"sunrise\": 1696428368, \"sunset\": 1696470468 } }"
        )
        composeTestRule.setContent {
            ForecastWeatherScreen(forecastData = forecastData)
        }
        composeTestRule
            .onNodeWithTag("WeatherForecastColumn")
            .assertExists()
        composeTestRule
            .onAllNodesWithTag("ForecastListItem")
            .assertCountEquals(5)
    }
}