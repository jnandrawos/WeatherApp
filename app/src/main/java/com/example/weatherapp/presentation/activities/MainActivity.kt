package com.example.weatherapp.presentation.activities

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.example.weatherapp.WeatherApp
import com.example.weatherapp.base.extensions.obtainViewModel
import com.example.weatherapp.presentation.components.CustomAppDrawerContent
import com.example.weatherapp.presentation.models.ThemeEnum
import com.example.weatherapp.presentation.screens.ErrorScreen
import com.example.weatherapp.presentation.screens.MainScreen
import com.example.weatherapp.presentation.viewmodels.WeatherViewModel
import com.example.weatherapp.ui.theme.WeatherAppTheme
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) {}
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    @OptIn(ExperimentalPermissionsApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WeatherApp.instance.activity = this
        locationPermissionRequest.launch(
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION
            )
        )
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        val weatherViewModel: WeatherViewModel by lazy {
            obtainViewModel(
                this, WeatherViewModel::class.java, defaultViewModelProviderFactory
            )
        }
        setContent {
            val permissionState =
                rememberPermissionState(permission = Manifest.permission.ACCESS_FINE_LOCATION)
            val drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            var themeModeState by remember {
                mutableStateOf(ThemeEnum.AUTO)
            }
            val coroutineScope = rememberCoroutineScope()

            WeatherAppTheme(
                darkTheme = when (themeModeState) {
                    ThemeEnum.LIGHT -> false
                    ThemeEnum.DARK -> true
                    else -> isSystemInDarkTheme()
                }
            ) {
                if (permissionState.hasPermission) {
                    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
                        CustomAppDrawerContent(themeToggleListener = {
                            themeModeState = it
                        }, deleteDataListener = {
                            weatherViewModel.deleteAllData()
                        })
                    }) {
                        MainScreen(weatherViewModel = weatherViewModel) {
                            coroutineScope.launch {
                                if (drawerState.isClosed) drawerState.open() else drawerState.close()
                            }
                        }
                    }
                } else {
                    ErrorScreen()
                }
            }
        }
    }
}