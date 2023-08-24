@file:OptIn(ExperimentalPermissionsApi::class)

package com.example.mocopraktikum23

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.RowScope
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mocopraktikum23.model.navigation.Navigation
import com.example.mocopraktikum23.model.navigation.NavigationGraph
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
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
            ) { NavigationGraph(navController)
                //Navigation()
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
