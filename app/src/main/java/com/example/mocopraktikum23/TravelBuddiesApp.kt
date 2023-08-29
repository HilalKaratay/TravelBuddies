@file:OptIn(ExperimentalPermissionsApi::class)
package com.example.mocopraktikum23

import android.annotation.SuppressLint
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mocopraktikum23.model.navigation.NavigationGraph
import com.example.mocopraktikum23.model.navigation.AppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
import com.example.mocopraktikum23.screens.MenuScreen
import com.example.mocopraktikum23.screens.ProfilScreen
import com.example.mocopraktikum23.screens.login.LoginScreen
import com.example.mocopraktikum23.screens.profil.ProfilInformationenScreen
import com.example.mocopraktikum23.screens.registrieren.RegistrierenScreen
import com.example.mocopraktikum23.ui.theme.MocoPraktikum23Theme
import com.google.accompanist.permissions.ExperimentalPermissionsApi

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
@ExperimentalMaterialApi
fun TravelBuddiesApp() {
    MocoPraktikum23Theme {
        Surface(color = MaterialTheme.colors.background) {

            val navController = rememberNavController()
            Scaffold(
                bottomBar = { BottomBar(navController = navController) }
            ) {
                Crossfade(targetState = AppRouter.currentScreen) { currentState ->
                    when (currentState.value) {

                        is ScreensNavigations.RegistrierenScreen -> {
                            RegistrierenScreen()
                        }
                        is ScreensNavigations.ProfilInformationenScreen -> {
                            ProfilInformationenScreen()
                        }
                        is ScreensNavigations.LoginScreen -> {
                            LoginScreen()
                        }
                        /*is ScreensNavigations.MenuScreen->{
                            MenuScreen()
                        }
                        is ScreensNavigations.MapScreen->{
                            MapScreen()
                        }
                        is ScreensNavigations.ProfilScreen->{
                            ProfilScreen()
                        }*/
                        else -> {
                            NavigationGraph(navController)
                        }
                    }
                }
            }
        }
    }
}

        @Composable
        fun BottomBar(navController: NavHostController) {
            val items = listOf(
                ScreensNavigations.ProfilScreen,
                ScreensNavigations.MapScreen,
                ScreensNavigations.MenuScreen
                )
            BottomNavigation {

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentState = navBackStackEntry?.destination?.route
                items.forEach { item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = (item.icon),
                                contentDescription = item.name
                            )
                        },
                        label = {
                            Text(
                                text = item.name,
                                fontSize = 9.sp
                            )
                        },
                        selectedContentColor = Color.Black,
                        unselectedContentColor = Color.Black.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = currentState == item.route,
                        onClick = {
                            navController.navigate(item.route) {
                                navController.graph.startDestinationRoute?.let { screen_route ->
                                    popUpTo(screen_route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }


