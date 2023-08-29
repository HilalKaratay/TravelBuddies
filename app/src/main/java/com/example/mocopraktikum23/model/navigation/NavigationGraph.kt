package com.example.mocopraktikum23.model.navigation

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.mocopraktikum23.MapScreen
import com.example.mocopraktikum23.screens.map.MapsActivity
import com.example.mocopraktikum23.model.navigation.ScreensNavigations.*
import com.example.mocopraktikum23.screens.MenuScreen
import com.example.mocopraktikum23.screens.ProfilScreen
import com.example.mocopraktikum23.screens.login.LoginScreen
import com.example.mocopraktikum23.screens.menu.OtherUserProfile
import com.example.mocopraktikum23.screens.profil.ProfilInformationenScreen
import com.example.mocopraktikum23.screens.registrieren.RegistrierenScreen
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnrememberedMutableState")
@ExperimentalFoundationApi
@ExperimentalAnimationApi
@ExperimentalPermissionsApi
@Composable
fun NavigationGraph(navController: NavHostController) {
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
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
            bottomBarState.value= true
            ProfilScreen()
        }

        composable("map") {
             bottomBarState.value= true
            MapScreen()
        }

        composable("registrieren") {
            RegistrierenScreen()
            bottomBarState.value= false
        }

        composable("login") {
            LoginScreen()
            bottomBarState.value= false
        }

        composable("menu") {
            bottomBarState.value= true
            MenuScreen()
        }

        composable("mapsactivity") {
            LaunchedEffect(Unit){ bottomBarState.value= true}
            MapsActivity()
        }

        composable("profilinformation" ){
            LaunchedEffect(Unit){ bottomBarState.value= false}
            ProfilInformationenScreen()
        }

        composable("otherUser"){
            OtherUserProfile()
        }
    }
}
