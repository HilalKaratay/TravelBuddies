package com.example.mocopraktikum23.model.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.mocopraktikum23.R


sealed class ScreensNavigations(val route: String, var icon: ImageVector, var name: String) {
    object LoginScreen : ScreensNavigations("login", Icons.Default.Create,"Login")
    object RegistrierenScreen : ScreensNavigations("registrieren", Icons.Default.Add,"Registrieren")
    object ProfilScreen : ScreensNavigations("profil", Icons.Default.Person,"Profil")
    object MapScreen : ScreensNavigations("map", Icons.Default.Map,"Map")
    object MenuScreen : ScreensNavigations("menu", Icons.Default.Menu,"Menu")
    object MapsActivity: ScreensNavigations("mapsActivity",Icons.Default.Create,"MapsActivity")
}

object PostOfficeAppRouter {
    var currentScreen: MutableState<ScreensNavigations> = mutableStateOf(ScreensNavigations.RegistrierenScreen)
    fun navigateTo(destination : ScreensNavigations){
        currentScreen.value = destination
    }
}