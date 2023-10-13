package com.example.weatherapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp

@Composable
inline fun <reified T : Enum<T>> MultiStateToggle(crossinline onSelectionChange: ((T) -> Unit)) {
    val states = enumValues<T>()
    var selectedOption by remember {
        mutableStateOf(states.first())
    }

    Surface(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .wrapContentSize()
    ) {
        Row(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
        ) {
            states.forEach { enumValue ->
                Text(
                    text = enumValue.name.lowercase().capitalize(Locale.current),
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    modifier = Modifier
                        .clip(shape = RoundedCornerShape(10.dp))
                        .clickable {
                            onSelectionChange.invoke(enumValue)
                            selectedOption = enumValue
                        }
                        .background(
                            if (enumValue == selectedOption) {
                                MaterialTheme.colorScheme.primary
                            } else {
                                MaterialTheme.colorScheme.onSurfaceVariant
                            }
                        )
                        .padding(
                            vertical = 12.dp,
                            horizontal = 16.dp,
                        ),
                )
            }
        }
    }
}