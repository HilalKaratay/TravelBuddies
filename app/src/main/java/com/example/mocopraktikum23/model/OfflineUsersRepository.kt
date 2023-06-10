package com.example.mocopraktikum23.model

import kotlinx.coroutines.flow.Flow

class OfflineUsersRepository(private val userDAO: UserDAO): UserRepository {
    override fun getAllUsersStream(): Flow<List<User>> = userDAO.getAllUser()

    override fun getUserStream(userID: Int): Flow<User?> =userDAO.getUser(userID)

    override suspend fun insertUser(user: User) = userDAO.insert(user)

    override suspend fun deleteUser(user: User) = userDAO.delete(user)

    override suspend fun updateUser(user: User)= userDAO.update(user)

}