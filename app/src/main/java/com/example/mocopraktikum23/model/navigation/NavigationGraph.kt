package com.example.mocopraktikum23.model.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.mocopraktikum23.MapScreen
import com.example.mocopraktikum23.MapsActivity
import com.example.mocopraktikum23.model.navigation.ScreensNavigations.*
import com.example.mocopraktikum23.screens.MenuScreen
import com.example.mocopraktikum23.screens.ProfilScreen
import com.example.mocopraktikum23.screens.login.LoginScreen
import com.example.mocopraktikum23.screens.registrieren.RegistrierenScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@SuppressLint("UnrememberedMutableState")
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(modifier = Modifier
            .clip(
                RoundedCornerShape(
                    bottomStart = 5.dp,
                    bottomEnd = 5.dp
                )
            )
            .padding(bottom = 65.dp),
        navController = navController,
        startDestination = "registrieren"
    ) {

        composable("profil") {
            ProfilScreen()
        }

        composable("map") {
            MapScreen()
        }

        composable("registrieren") {
            RegistrierenScreen()
        }

        composable("login") {
            LoginScreen()
        }

        composable("menu") {
            MenuScreen()
        }

        composable("mapsactivity") {
            MapsActivity()
        }
    }

}
