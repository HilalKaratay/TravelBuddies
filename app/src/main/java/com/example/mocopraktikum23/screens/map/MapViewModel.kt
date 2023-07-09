package com.example.mocopraktikum23.screens.map

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserDAO
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import kotlinx.coroutines.launch

//com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel @Inject constructor(createSavedStateHandle: SavedStateHandle) : ViewModel() {

    private val databaseRef: DatabaseReference

    val users: MutableState<List<User>> = mutableStateOf(emptyList())
    val loading: MutableState<Boolean> = mutableStateOf(false)

    init {
        // Firebase-Datenbankreferenz initialisieren
        databaseRef = FirebaseDatabase.getInstance().reference

        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            loading.value = true

            // Benutzerdaten von Firebase abrufen
            databaseRef.child("users").addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val userList = mutableListOf<User>()
                    for (userSnapshot in snapshot.children) {
                        val user = userSnapshot.getValue(User::class.java)
                        user?.let {
                            userList.add(it)
                        }
                    }
                    users.value = userList
                    loading.value = false
                }

                override fun onCancelled(error: DatabaseError) {
                    // Fehlerbehandlung bei Datenbankfehler
                    loading.value = false
                }
            })
        }
    }
}