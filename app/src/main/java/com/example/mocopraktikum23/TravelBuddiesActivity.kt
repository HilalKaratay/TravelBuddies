package com.example.mocopraktikum23

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.mutableStateOf
import com.google.android.material.bottomnavigation.BottomNavigationView

@ExperimentalMaterialApi
class TravelBuddiesActivity : AppCompatActivity() {
   //Für die Map implemenation - acress auf standort
   companion object {
        const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1234
    }

    private val locationPermissionGranted = mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { TravelBuddiesApp()
        }
    }
}

