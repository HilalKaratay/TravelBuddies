package com.example.mocopraktikum23

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.merveversuch10000.ui.theme.ProfilErstellenScreen
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.service.DatenSpeicher
import com.example.mocopraktikum23.screens.MenuScreen
import com.example.mocopraktikum23.screens.ProfilScreen
import com.example.mocopraktikum23.screens.map.MapViewModel
import com.example.mocopraktikum23.screens.menu.MenuViewModel
import com.example.mocopraktikum23.screens.profil.ProfilViewModel
import com.example.mocopraktikum23.screens.profilerstellen.ProfilErstellenViewModel
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport

@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier) {

    NavHost(
        navController = navController,
        startDestination = NavigationBarScreen.Menu.route
    )
    {
        composable(route = NavigationBarScreen.Profil.route) {
            ProfilScreen(ProfilViewModel())
        }
        composable(route = NavigationBarScreen.Map.route) {
            MapScreen(MapViewModel())
        }
        composable(route = NavigationBarScreen.Menu.route) {
            MenuScreen(MenuViewModel())
        }
        composable(route = NavigationBarScreen.Profilerstellen.route) {
            //ProfilErstellenScreen(ProfilErstellenViewModel(datenSpeicher = DatenSpeicher))

        }
    }
}