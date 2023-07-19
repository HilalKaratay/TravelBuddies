package com.example.mocopraktikum23.model.service

import com.example.mocopraktikum23.model.User
import kotlinx.coroutines.flow.Flow

interface DatenSpeicher {
        val users: Flow<List<User>>
        suspend fun getUser(userId: String): User?
        suspend fun save(user: User): String
        suspend fun update(user: User)
        suspend fun delete(userID: String)
}

