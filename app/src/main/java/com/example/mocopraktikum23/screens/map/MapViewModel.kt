package com.example.mocopraktikum23.screens.map

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient

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
