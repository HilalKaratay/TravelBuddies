package com.example.mocopraktikum23

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mocopraktikum23.Screens.MenuScreen
import com.example.mocopraktikum23.Screens.ProfilScreen

@Composable
fun BottomNavGraph(navController: NavHostController){

    NavHost(
        navController = navController,
        startDestination = NavigationBarScreen.Menu.route)
    {
        composable(route =NavigationBarScreen.Profil.route){
            ProfilScreen()
        }
        composable(route =NavigationBarScreen.Map.route){
            MapScreen()
        }
        composable(route =NavigationBarScreen.Menu.route){
            MenuScreen()
        }

    }
}