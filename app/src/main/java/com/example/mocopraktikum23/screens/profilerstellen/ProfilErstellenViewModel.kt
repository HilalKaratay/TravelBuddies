package com.example.mocopraktikum23.screens.profilerstellen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserRepository
import kotlinx.coroutines.launch

class ProfilErstellenViewModel(private val userRepository: UserRepository) : ViewModel() {
    val uploadSuccess: MutableLiveData<Boolean> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()

    fun uploadUserData(userData: UserData) {
        val user = User(
            name = userData.Benutzernamen,
            alter = userData.Alter.toString(),
            wohnort = userData.Wohnort,
            reiseziele = userData.Reiseziele.joinToString(","),
            geseheneOrte = userData.GeseheneOrte.joinToString(",")
        )

        viewModelScope.launch {
            try {
                userRepository.insertUser(user)
                uploadSuccess.value = true
            } catch (e: Exception) {
                error.value = "Fehler beim Hochladen des Profils: ${e.message}"
            }
        }
    }
}

data class UserData(
    val Benutzernamen: String,
    val Alter: Int,
    val Wohnort: String,
    val Reiseziele: List<String>,
    val GeseheneOrte: List<String>
)