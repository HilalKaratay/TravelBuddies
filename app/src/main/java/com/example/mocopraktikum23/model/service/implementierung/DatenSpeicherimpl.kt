package com.example.mocopraktikum23.model.service.implementierung

import androidx.core.os.trace
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.service.DatenSpeicher
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.dataObjects
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.tasks.await
import java.lang.reflect.Array.get
import javax.inject.Inject

class DatenSpeicherimpl
@Inject
constructor(private val firestore: FirebaseFirestore):
    DatenSpeicher {
    @OptIn(ExperimentalCoroutinesApi::class)
    override val users : Flow<List<User>>
    get() = firestore.collection(USER_COLLECTION).dataObjects()

    override suspend fun getUser (userID: String): User?=
        firestore.collection(USER_COLLECTION).document(userID).get().await().toObject()

   override suspend fun save(user: User): String =
    trace(SAVE_USER_TRACE){
            val userWithUserId = user.copy()
            firestore.collection(SAVE_USER_TRACE).add(userWithUserId).await().id

        }

    override suspend fun update(user: User) {
        trace(UPDATE_USER_TRACE) {
            firestore.collection(USER_COLLECTION).document(user.userid.toString()).set(user).await()
        }
    }

    override suspend fun delete(userID: String) {
        firestore.collection(USER_COLLECTION).document(userID).delete().await()
    }

    companion object {
        private const val USER_ID_FIELD = "userId"
        private const val USER_COLLECTION = "users"
        private const val SAVE_USER_TRACE = "saveUser"
        private const val UPDATE_USER_TRACE = "updateUser"
    }
}
