package com.example.weatherapp.presentation.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.ui.graphics.vector.ImageVector

data class TabItem(
    val title: String? = null,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
) {
    companion object {
        val tabItems = listOf(
            TabItem(
                title = "Current",
                unselectedIcon = Icons.Outlined.Cloud,
                selectedIcon = Icons.Filled.Cloud,
            ),
            TabItem(
                title = "Forecast",
                unselectedIcon = Icons.Outlined.DateRange,
                selectedIcon = Icons.Filled.DateRange,
            ),
        )
    }
}
