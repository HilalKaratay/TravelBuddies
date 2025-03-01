package com.example.mocopraktikum23.model.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MyLocation
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class ScreensNavigations(val route: String, var icon: ImageVector, var name: String) {
    object RegistrierenScreen : ScreensNavigations("registrieren", Icons.Default.Add,"registrieren")
    object LoginScreen : ScreensNavigations("login", Icons.Default.Create,"login")
    object ProfilScreen : ScreensNavigations("profil", Icons.Default.Person,"Profil")
    object MapScreen : ScreensNavigations("map", Icons.Default.Map,"Map")
    object MenuScreen : ScreensNavigations("menu", Icons.Default.MyLocation,"In der Nahe")
    object MapsActivity: ScreensNavigations("mapsActivity",Icons.Default.Create,"MapsActivity")
    object ProfilInformationenScreen: ScreensNavigations("profilinformationen", Icons.Default.Check,"ProfilInformationen")
    object OtherUserProfile: ScreensNavigations("otherUser",Icons.Default.Check,"OtherUser")
}

object AppRouter {
    var currentScreen: MutableState<ScreensNavigations> = mutableStateOf(ScreensNavigations.MenuScreen)
    fun navigateTo(destination : ScreensNavigations){
        currentScreen.value = destination
    }
}