package com.example.weatherapp.presentation.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R
import com.example.weatherapp.base.extensions.obtainViewModel
import com.example.weatherapp.base.utils.GlobalVars
import com.example.weatherapp.presentation.components.UsersDataListItem
import com.example.weatherapp.presentation.models.ThemeEnum
import com.example.weatherapp.presentation.viewmodels.UsersDataViewModel
import com.example.weatherapp.ui.theme.WeatherAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersDataActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val themeMode: String? = intent.getStringExtra(GlobalVars.THEME_BUNDLE)

        val userDataViewModel: UsersDataViewModel by lazy {
            obtainViewModel(
                this, UsersDataViewModel::class.java, defaultViewModelProviderFactory
            )
        }
        userDataViewModel.getDatabaseEntries()

        setContent {
            WeatherAppTheme(
                darkTheme = when (themeMode) {
                    ThemeEnum.LIGHT.name -> false
                    ThemeEnum.DARK.name -> true
                    else -> isSystemInDarkTheme()
                }
            ) {
                val state = userDataViewModel.databaseEntriesState.collectAsState()
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    Column(
                        modifier =
                        Modifier
                            .padding(it)
                            .padding(horizontal = 10.dp)
                            .fillMaxSize()
                    ) {
                        Text(
                            text = stringResource(R.string.usersData_display_title),
                            color = MaterialTheme.colorScheme.onBackground,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 48.sp,
                            textAlign = TextAlign.Start
                        )
                        Spacer(
                            modifier = Modifier
                                .height(10.dp)
                        )
                        LazyColumn {
                            itemsIndexed(state.value.orEmpty()) { index, weatherDatabaseModel ->
                                UsersDataListItem(weatherDatabaseModel)
                                if (index < state.value.orEmpty().size) Spacer(
                                    modifier = Modifier.height(
                                        10.dp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}