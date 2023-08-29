package com.example.mocopraktikum23.screens.profil

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.google.firebase.firestore.ktx.firestore

class ProfilViewModel : ViewModel() {

    private val _signedInUser = MutableStateFlow<FirebaseUser?>(null)
    val signedInUser = _signedInUser.asStateFlow()

    private val _userDataFromDB = MutableStateFlow<ProfilInfoUiState?>(null)
    val userDataFromDB = _userDataFromDB.asStateFlow()

    private val dataFromDb = MutableStateFlow<ProfilInfoUiState?>(null)
    val newDataFromDB = dataFromDb.asStateFlow()
    val db = Firebase.firestore

    /*  FIRESTORE REALTIME DATABASE*/
    fun readFromDatabase() {
        _signedInUser.value = FirebaseAuth.getInstance().currentUser

        val user = _signedInUser.value
        user?.run {
            val userIDReference= Firebase.database.reference.child("User").child(uid)

            userIDReference.get().addOnSuccessListener { dataSnapShot ->
                val userData = dataSnapShot.getValue<ProfilInfoUiState?>()
                _userDataFromDB.value = userData
            }
        }
    }

    fun differentReadFromDatabase() {
        _signedInUser.value = FirebaseAuth.getInstance().currentUser

        val userData = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val name = dataSnapshot.getValue<ProfilInfoUiState>()
                dataFromDb.value = name
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        //databaseReference.addValueEventListener(userData)
    }


}