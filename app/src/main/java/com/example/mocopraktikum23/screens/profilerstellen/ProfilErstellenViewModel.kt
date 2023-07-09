package com.example.mocopraktikum23.screens.profilerstellen

import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.User
import kotlinx.coroutines.launch

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mocopraktikum23.model.UserRepository
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ProfilErstellenViewModel(userRepository: UserRepository) : ViewModel() {
    private val firebaseDatabase: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val databaseRef: DatabaseReference = firebaseDatabase.reference

    private val _uploadSuccess = MutableLiveData<Boolean>()
    val uploadSuccess: LiveData<Boolean> = _uploadSuccess

    var userUiState by mutableStateOf(UserUiState())
        private set

    fun updateUiState(userDetails: UserDetails) {
        userUiState = UserUiState(userDetails = userDetails, isEntryValid = validateInput(userDetails))
    }

    suspend fun saveUser() {
        if (validateInput()) {
            val userDetails = userUiState.userDetails
            uploadUserData(userDetails)
        }
    }

    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            benutzername.isNotBlank() && alter.isNotBlank() && wohnort.isNotBlank() && reiseZiele.isNotBlank() && geseheneOrte.isNotBlank()
        }
    }

    private fun uploadUserData(userData: UserDetails) {
        val user = User(
            benutzername = userData.benutzername,
            alter = userData.alter,
            wohnort = userData.wohnort,
            reiseZiele = userData.reiseZiele,
            geseheneOrte = userData.geseheneOrte
        )

        databaseRef.child("users").push().setValue(user)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    _uploadSuccess.postValue(true)
                } else {
                    _uploadSuccess.postValue(false)
                }
            }
    }
}

data class UserUiState(
    val userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)

data class UserDetails(
    val benutzername: String = "",
    val alter: String = "",
    val wohnort: String = "",
    val reiseZiele: String = "",
    val geseheneOrte: String = ""
)

data class User(
    val benutzername: String = "",
    val alter: String = "",
    val wohnort: String = "",
    val reiseZiele: String = "",
    val geseheneOrte: String = ""
)
/*class ProfilErstellenViewModel(/*private val userRepository: UserRepository*/) : ViewModel() {
   private val _uploadSuccess = MutableLiveData<Boolean>()
    val uploadSuccess: LiveData<Boolean> = _uploadSuccess

    private val userRepository : UserRepository //muss geändert werden
        get() {
            TODO()
        }

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun uploadUserData(userData: UserData) {
        val user = User(
            name = userData.Benutzernamen,
            alter = userData.Alter.toString(),
            wohnort = userData.Wohnort,
            reiseZiele = userData.reiseziele.joinToString(","),
            geseheneOrte = userData.GeseheneOrte.joinToString(",")
        )

        viewModelScope.launch {
          try {
              userRepository.insertUser(user)
              _uploadSuccess.value = true
          } catch (e: Exception) {
              _error.value = "Fehler beim Hochladen des Profils: ${e.message}"
          }
        }
    }
}

data class UserData(
    val Benutzernamen: String,
    val Alter: Int,
    val Wohnort: String,
    val reiseziele: List<String>,
    val GeseheneOrte: List<String>
)

 */