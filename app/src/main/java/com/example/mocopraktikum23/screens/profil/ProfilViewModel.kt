package com.example.mocopraktikum23.screens.profil

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

//import UserDetails
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
            name = userData.benutzername,
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
/*@HiltViewModel
class ProfilViewModel @Inject constructor(
    private val repository: UserRepository
    ) : ViewModel() {

    val user = mutableStateOf<User?>(null)
    var loading = mutableStateOf(false)

    init {
        getUser()
    }
    private fun getUser() {
        viewModelScope.launch {
            loading.value = true
            user.value = user.getA
            loading.value = false
        }
    }
}
 class ProfilViewModel(): ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
     }
 }
//data class ProfilUiState(val userDetails: UserDetails = UserDetails())
 */