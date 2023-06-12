package com.example.mocopraktikum23.screens

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mocopraktikum23.BottomNavGraph
import com.example.mocopraktikum23.NavigationBarScreen

@Composable
fun MainScreen() {

    val navController = rememberNavController()
    Scaffold(
        //scaffoldState = scaffoldState,
        topBar = { Toolbar() },
        bottomBar = { BottomBar(navController = navController)},
        )

    { innerPadding ->
        BottomNavGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Composable
fun Toolbar() {
        TopAppBar(
            backgroundColor = Color.Gray,
            elevation = 4.dp,
            title = {
                Text(
                    text = "TravelBuddies",
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 30.sp,
                )
            })
    } //Das könnte man noch ausarbeiten. Hinzufügen des NAMENS der aktuellen seite


@Composable
fun BottomBar(navController: NavHostController ) {

    val screens = listOf(
        NavigationBarScreen.Map,
        NavigationBarScreen.Menu,
        NavigationBarScreen.Profil,
        NavigationBarScreen.ProfilErstellen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    BottomNavigation (   backgroundColor = Color.Gray    ){

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
    screen:NavigationBarScreen,
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
                contentDescription = "Navigation Icon")

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

