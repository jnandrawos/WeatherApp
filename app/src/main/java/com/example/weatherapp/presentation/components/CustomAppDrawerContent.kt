package com.example.weatherapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.presentation.models.ThemeEnum
import com.example.weatherapp.source.local.WeatherDatabase

@Composable
fun CustomAppDrawerContent(
    themeToggleListener: ((ThemeEnum) -> Unit)?,
    deleteDataListener: (() -> Unit)?,
    checkDataListener: (() -> Unit)?,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(MaterialTheme.colorScheme.background)
            .padding(10.dp)
    ) {
        Text(
            text = "Choose theme:",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(10.dp))
        MultiStateToggle<ThemeEnum> {
            themeToggleListener?.invoke(it)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Delete data:",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                deleteDataListener?.invoke()
            }, colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.error,
                contentColor = MaterialTheme.colorScheme.onError,
                disabledContainerColor = MaterialTheme.colorScheme.error.copy(
                    alpha = 0.5f
                ),
                disabledContentColor = MaterialTheme.colorScheme.onError.copy(
                    alpha = 0.5f
                ),
            )
        ) {
            Text(text = "Delete Weather Data")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Database Version: ${WeatherDatabase.DB_VERSION}",
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.fillMaxWidth(),
            fontSize = 16.sp,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {
                checkDataListener?.invoke()
            }, colors = ButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
                disabledContainerColor = MaterialTheme.colorScheme.primary.copy(
                    alpha = 0.5f
                ),
                disabledContentColor = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.5f
                ),
            )
        ) {
            Text(text = "Check Database Data")
        }
    }
}