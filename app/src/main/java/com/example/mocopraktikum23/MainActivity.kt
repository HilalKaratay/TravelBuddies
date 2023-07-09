package com.example.mocopraktikum23

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mocopraktikum23.model.AppContainer
import com.example.mocopraktikum23.model.AppDataContainer
import com.example.mocopraktikum23.screens.MainScreen
import com.example.mocopraktikum23.ui.theme.MocoPraktikum23Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MocoPraktikum23Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background )
                {
                  MainScreen()
                }
                }
            }
        }
    }
