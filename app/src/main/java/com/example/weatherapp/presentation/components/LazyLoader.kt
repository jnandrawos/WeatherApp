package com.example.weatherapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Error
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.weatherapp.base.models.Status


@Composable
fun LazyLoader(
    status: Status?,
    content: @Composable () -> Unit,
) = when (status) {
    Status.LOADING -> Box {
        content()
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.align(Alignment.Center)
        )
    }

    Status.ERROR -> {
        Box {
            content()
            Icon(
                imageVector = Icons.Rounded.Error,
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }

    else -> {
        content()
    }
}