package com.example.mocopraktikum23

import android.app.Application
import com.example.mocopraktikum23.model.AppContainer
import com.example.mocopraktikum23.model.AppDataContainer

class MainApplication : Application() {

   lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}