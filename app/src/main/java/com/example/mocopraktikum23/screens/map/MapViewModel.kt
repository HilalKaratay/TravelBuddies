package com.example.mocopraktikum23.screens.map

import android.content.pm.PackageManager
import androidx.compose.material.Text
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.Manifest
import com.example.mocopraktikum23.Manifest.*
import com.example.mocopraktikum23.MapScreen
import com.example.mocopraktikum23.TravelBuddiesViewModel
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.service.LoginService

import javax.inject.Inject

class MapViewModel @Inject constructor(logService: LoginService) : TravelBuddiesViewModel(logService) {
}/*
    val users: MutableState<List<User>> = mutableStateOf(emptyList())
    val loading: MutableState<Boolean> = mutableStateOf(false)
    companion object {
        const val PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION = 1234
    }

    private val locationPermissionGranted = mutableStateOf(false)

        Places.initialize(applicationContext, getString(R.string.MAPS_API_KEY))

            getLocationPermission()
            if (locationPermissionGranted.value) {
                MapScreen()
            }else{
                Text("Need permission")
            }
        }
    }


    @Deprecated("Deprecated in Java")
    fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode== PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            locationPermissionGranted.value=true
        }
    }

private fun getLocationPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                permission.ACCESS_FINE_LOCATION
            )
            == PackageManager.PERMISSION_GRANTED
        ) {
            locationPermissionGranted.value = true
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(permission.ACCESS_FINE_LOCATION),
                PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION
            )
        }
    }
*/
