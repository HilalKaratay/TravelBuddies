@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.mocopraktikum23

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mocopraktikum23.model.navigation.NavigationGraph
import com.example.mocopraktikum23.model.navigation.PostOfficeAppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
import com.example.mocopraktikum23.screens.MenuScreen
import com.example.mocopraktikum23.screens.ProfilScreen
import com.example.mocopraktikum23.screens.login.LoginScreen
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
                Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
                    when (currentState.value) {
                        is ScreensNavigations.RegistrierenScreen -> {
                            RegistrierenScreen()
                        }

                        is ScreensNavigations.MenuScreen -> {
                            MenuScreen()
                        }

                        is ScreensNavigations.LoginScreen -> {
                            LoginScreen()
                        }

                        else -> {
                            NavigationGraph(navController)
                            //BottomBar(navController = navController)}
                        }
                    }


                }
            }
        }
    }
}
        @Composable
        fun BottomBar(navController: NavHostController) {
            val screens = listOf(
                ScreensNavigations.ProfilScreen,
                ScreensNavigations.MapScreen,
                ScreensNavigations.MenuScreen,
            )
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination

            BottomNavigation {
                screens.forEach { screen ->
                    AddItem(
                        screen = screen,
                        currentDestination = currentDestination,
                        navController = navController
                    )
                }
            }
        }

        @Composable
        fun RowScope.AddItem(
            screen:ScreensNavigations,
            currentDestination: NavDestination?,
            navController: NavHostController
        ) {
            BottomNavigationItem(
                label = {
                    Text(text = screen.name)
                },
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = "Navigation Icon"
                    )
                },
                selected = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id)
                        launchSingleTop = true
                    }
                }
            )
        }
