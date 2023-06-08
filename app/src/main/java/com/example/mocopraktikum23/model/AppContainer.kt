package com.example.mocopraktikum23.model

import android.content.Context

interface AppContainer {
    val userRepository: UserRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    override val userRepository: UserRepository by lazy {
       OfflineUsersRepository(DatabaseUser.getDatabase(context).userDAO())
    }
}