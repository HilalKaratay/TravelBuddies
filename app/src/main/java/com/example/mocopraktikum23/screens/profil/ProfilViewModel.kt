package com.example.mocopraktikum23.screens.profil

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfilViewModel() {

    val firebaseDatabase = FirebaseDatabase.getInstance("https://moco-30a5f-default-rtdb.europe-west1.firebasedatabase.app/")
    val databaseReference = firebaseDatabase.getReference("User").push()

    private val _signedInUser = MutableStateFlow<FirebaseUser?>(null)
    val signedInUser = _signedInUser.asStateFlow()

    private val _userDataFromDB = MutableStateFlow<ProfilInfoUiState?>(null)
    val userDataFromDB = _userDataFromDB.asStateFlow()

    private val dataFromDb = MutableStateFlow<ProfilInfoUiState?>(null)
    val newDataFromDB = dataFromDb.asStateFlow()

    fun readFromDatabase() {
        _signedInUser.value = FirebaseAuth.getInstance().currentUser

        val user = _signedInUser.value
        user?.run {
            val userIdReference = Firebase.database.reference.child("User").child(uid)

            userIdReference.get().addOnSuccessListener { dataSnapShot ->
                val userData = dataSnapShot.getValue<ProfilInfoUiState?>()
                _userDataFromDB.value = userData
            }
        }
    }

    fun differentReadFromDatabase() {
        _signedInUser.value = FirebaseAuth.getInstance().currentUser

        val userData = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue<ProfilInfoUiState>()
                dataFromDb.value = user
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        databaseReference.addValueEventListener(userData)
    }


}