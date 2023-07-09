package com.example.mocopraktikum23

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mocopraktikum23.screens.MainScreen
import com.example.mocopraktikum23.screens.map.MapViewModel
import com.example.mocopraktikum23.screens.menu.MenuViewModel
import com.example.mocopraktikum23.screens.profil.ProfilViewModel
import com.example.mocopraktikum23.screens.profilerstellen.ProfilErstellenViewModel
import com.example.mocopraktikum23.MainApplication

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            ProfilViewModel(this.createSavedStateHandle())

        }
        initializer {
          ProfilErstellenViewModel(mainApplication().container.userRepository)
        }

        initializer {
            MapViewModel(this.createSavedStateHandle())
        }

        initializer {
            MenuViewModel()
        }
    }
}
fun CreationExtras.mainApplication(): MainApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MainApplication)