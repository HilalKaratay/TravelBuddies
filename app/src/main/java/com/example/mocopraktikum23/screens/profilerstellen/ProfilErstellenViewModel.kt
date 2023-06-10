package com.example.mocopraktikum23.screens.profilerstellen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.LiveData
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserRepository
import kotlinx.coroutines.launch

class ProfilErstellenViewModel(/*private val userRepository: UserRepository*/) : ViewModel() {
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