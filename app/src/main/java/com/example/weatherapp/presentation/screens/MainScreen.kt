package com.example.weatherapp.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.weatherapp.WeatherApp
import com.example.weatherapp.base.extensions.getLastLocation
import com.example.weatherapp.base.extensions.safe
import com.example.weatherapp.base.extensions.showToast
import com.example.weatherapp.base.models.Status
import com.example.weatherapp.presentation.components.CustomFloatingActionButton
import com.example.weatherapp.presentation.components.CustomTopBar
import com.example.weatherapp.presentation.components.LazyLoader
import com.example.weatherapp.presentation.models.TabItem
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(weatherViewModel: WeatherViewModel, updateDrawerState: () -> Unit) {
    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        TabItem.tabItems.size
    }

    fun getData() {
        weatherViewModel.weatherStatus.value = Status.LOADING
        WeatherApp.instance.getLastLocation { lat, long ->
            weatherViewModel.getCurrentWeather(lat, long)
            weatherViewModel.getForecastWeather(lat, long)
        }
    }
    LaunchedEffect(selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(pagerState.currentPage) {
        selectedTabIndex = pagerState.currentPage
    }

    LaunchedEffect(Unit) {
        getData()
    }

    val weatherData = weatherViewModel.currentWeatherState.collectAsState()
    val weatherStatus by remember {
        weatherViewModel.weatherStatus
    }
    val forecastData = weatherViewModel.forecastWeatherState.collectAsState()
    val forecastStatus by remember {
        weatherViewModel.forecastStatus
    }
    val wasDeleted by remember {
        weatherViewModel.wasDeleted
    }

    LaunchedEffect(wasDeleted) {
        if (wasDeleted) {
            WeatherApp.instance.activity.showToast("Data has been deleted successfully")
        }
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        floatingActionButton = {
            CustomFloatingActionButton {
                getData()
            } },
        topBar = {
            CustomTopBar(weatherData = weatherData, updateDrawerState = updateDrawerState)
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) { index ->
                when (index) {
                    0 -> LazyLoader(status = weatherStatus) {
                        CurrentWeatherScreen(weatherData = weatherData.value)
                    }

                    else -> LazyLoader(status = forecastStatus) {
                        ForecastWeatherScreen(forecastData = forecastData.value)
                    }
                }
            }
            TabRow(selectedTabIndex = selectedTabIndex) {
                TabItem.tabItems.forEachIndexed { index, tabItem ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = {
                            selectedTabIndex = index
                        },
                        text = {
                            Text(
                                text = tabItem.title.safe(),
                                color = MaterialTheme.colorScheme.primary
                            )
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedTabIndex) tabItem.selectedIcon else tabItem.unselectedIcon,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    )
                }
            }
        }
    }
}