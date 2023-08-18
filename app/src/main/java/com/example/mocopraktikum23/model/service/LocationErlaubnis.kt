package com.example.mocopraktikum23.model.service

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberPermissionState
import com.google.accompanist.permissions.*
import android.Manifest
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.google.accompanist.permissions.rememberMultiplePermissionsState
/*
@ExperimentalPermissionsApi
@Composable
fun LocationErlaubnis(
    navigateToSettingsScreen: () -> Unit,
    content: @Composable () -> Unit
) {
    var doNotShowRationale by rememberSaveable { mutableStateOf(false) }
    val locationPermissionState =
        rememberPermissionState(Manifest.permission.ACCESS_COARSE_LOCATION)
    val fineLocationPermissionState = rememberMultiplePermissionsState(
        listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION,
        ),
    )
    PermissionRequired(
        permissionState = locationPermissionState,
        permissionNotGrantedContent = {
            if (doNotShowRationale) {
                Text(text = "Nicht verfügbar")
            } else {
                Column(
                    modifier = Modifier
                        .height(200.dp)
                        .background(Color.LightGray)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        modifier = Modifier.padding(bottom = 10.dp),
                        color = Color.LightGray,
                        text= "Der Standort ist wichtig für die Nutzung der App. Bitte ändern Sie die Einstellungen")
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Button(onClick = {
                            locationPermissionState.launchPermissionRequest()
                        }) {
                            Text("Allow")
                        }
                        Spacer(Modifier.width(8.dp))
                        Button(onClick = { doNotShowRationale = true }) {
                            Text("Deny")
                        }
                    }
                }
            }
        },
        permissionNotAvailableContent = {
            Column(
                Modifier
                    .height(200.dp)
                    .background(Color.LightGray)
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Location konnte nicht aberufen werden! wenden Sie sich an den Support"
                )
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = navigateToSettingsScreen) {
                    Text("Open Settings")
                }
            }
        },
        content = content

    )
}*/