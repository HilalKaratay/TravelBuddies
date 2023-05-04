package com.example.mocopraktikum23


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationBarScreen(var route: String, var icon: ImageVector, var name: String) {

   object Menu : NavigationBarScreen(
            name = "menü",
            route = "Menu",
            icon = Icons.Default.Menu,
        )

    object Profil : NavigationBarScreen(
            name = "profil",
            route = "Profil",
            icon = Icons.Default.Person,
    )
    object Map: NavigationBarScreen(
            name = "map",
            route = "Map",
            icon = Icons.Default.Home,
    )


}



