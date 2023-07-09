package com.example.mocopraktikum23.screens.profil

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

//import UserDetails
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.screens.profilerstellen.UserDetails
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.launch

class ProfilViewModel(createSavedStateHandle: SavedStateHandle) : ViewModel() {
    private val databaseRef: DatabaseReference

    init {
        // Firebase-Datenbankreferenz initialisieren
        databaseRef = FirebaseDatabase.getInstance().reference
    }

    fun uploadUserData(userData: UserDetails) {
        val user = User(
            benutzername = userData.benutzername,
            alter = userData.alter,
            wohnort = userData.wohnort,
            reiseZiele = userData.reiseZiele,
            geseheneOrte = userData.geseheneOrte
        )

        viewModelScope.launch {
            // Benutzerdaten hochladen
            databaseRef.child("users").push().setValue(user)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Upload erfolgreich
                        // Hier können Sie entsprechende Aktionen ausführen, z.B. ein LiveData-Objekt aktualisieren
                    } else {
                        // Upload fehlgeschlagen
                        // Hier können Sie entsprechende Aktionen ausführen, z.B. Fehlerbehandlung
                    }
                }
        }
    }
}