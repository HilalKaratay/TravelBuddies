package com.example.mocopraktikum23


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationBarScreen(var route: String, var icon: ImageVector, var name: String) {

    object Menu : NavigationBarScreen(
            name = "Menü",
            route = "Menu",
            icon = Icons.Default.Menu,
        )

    object Profil : NavigationBarScreen(
            name = "Profil",
            route = "Profil",
            icon = Icons.Default.Person,
    )
    object Map: NavigationBarScreen(
            name = "Map",
            route = "Map",
            icon = Icons.Default.Home,
    )
    object ProfilErstellen: NavigationBarScreen(
        name = "ProfilErstellen",
        route = "ProfilErstellen",
        icon = Icons.Default.Person,
    )


}



