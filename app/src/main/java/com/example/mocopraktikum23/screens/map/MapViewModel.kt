package com.example.mocopraktikum23.screens.map

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.MapScreen
import com.example.mocopraktikum23.TravelBuddiesViewModel
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.service.LoginService
import com.google.android.gms.location.FusedLocationProviderClient

import javax.inject.Inject

class MapViewModel : ViewModel(){
    @SuppressLint("MissingPermission")
    fun getDeviceLocation(
        fusedLocationProviderClient: FusedLocationProviderClient
    ) {
        try {
            val locationResult = fusedLocationProviderClient.lastLocation
            locationResult.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    println("Location is OK")
                }
            }
        } catch (e: SecurityException) {
            println("ERROR")
        }
    }
}
