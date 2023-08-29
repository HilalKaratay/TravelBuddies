package com.example.mocopraktikum23.model.navigation

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem (val name: String,
                          val route: String,
                          val icon: ImageVector,
                          val onSelectedBatchVisible: Boolean,
)