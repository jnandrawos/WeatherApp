package com.example.weatherapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomFloatingActionButton(onClick: (()->Unit)?){
    FloatingActionButton(
        onClick = {
            onClick?.invoke()
        },
        modifier = Modifier.padding(bottom = 60.dp),
        shape = RoundedCornerShape(100.dp),
        containerColor = MaterialTheme.colorScheme.primary,
        elevation = FloatingActionButtonDefaults.elevation(
            defaultElevation = 0.dp
        )
    ) {
        Icon(
            imageVector = Icons.Filled.Refresh,
            tint = MaterialTheme.colorScheme.onPrimary,
            contentDescription = "refresh"
        )
    }
}