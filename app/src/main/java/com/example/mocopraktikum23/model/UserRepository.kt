package com.example.mocopraktikum23.model

import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getAllUsersStream(): Flow<List<User>>

    fun getUserStream(userID : Int): Flow<User?>

   suspend fun insertUser(user: User)

   suspend fun deleteUser(user: User)

   suspend fun updateUser(user: User)

}