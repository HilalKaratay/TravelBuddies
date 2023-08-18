package com.example.mocopraktikum23.model.navigation
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mocopraktikum23.MapScreen
import com.example.mocopraktikum23.screens.MenuScreen
import com.example.mocopraktikum23.screens.ProfilScreen
import com.example.mocopraktikum23.screens.login.LoginScreen
import com.example.mocopraktikum23.screens.menu.MenuViewModel
import com.example.mocopraktikum23.screens.registrieren.RegistrierenScreen

@Composable
fun Navigation(menuViewModel: MenuViewModel = viewModel()) {

    menuViewModel.checkForActiveSession()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {

        if (menuViewModel.isUserLoggedIn.value == true) {
            PostOfficeAppRouter.navigateTo(ScreensNavigations.MenuScreen)
        }

        Crossfade(targetState = PostOfficeAppRouter.currentScreen) { currentState ->
            when (currentState.value) {
                is ScreensNavigations.RegistrierenScreen -> {
                    RegistrierenScreen()
                }

                is ScreensNavigations.LoginScreen -> {
                    LoginScreen()
                }

                is ScreensNavigations.ProfilScreen -> {
                    ProfilScreen()
                }

                is ScreensNavigations.MenuScreen -> {
                    MenuScreen()
                }
                is ScreensNavigations.MapScreen -> {
                MapScreen()
            }

                ScreensNavigations.MapsActivity -> TODO()
            }
        }

    }
}