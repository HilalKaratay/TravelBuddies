package com.example.mocopraktikum23.repository

import com.example.mocopraktikum23.model.DataOrException
import com.example.mocopraktikum23.model.User
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class UserRepository @Inject constructor(
    private val queryUsers: Query
) {
    suspend fun getUserFromFirestore(): DataOrException<List<User>, Exception> {
        val dataOrException = DataOrException<List<User>, Exception>()
        try {
            dataOrException.data = queryUsers.get().await().map { document ->
                document.toObject(User::class.java)
            }
        } catch (e: FirebaseFirestoreException) {
            dataOrException.e = e
        }
        return dataOrException
    }
}