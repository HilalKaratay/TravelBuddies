package com.example.mocopraktikum23.screens.profilerstellen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserRepository

class ProfilErstellenViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _uploadSuccess = MutableLiveData<Boolean>()
    val uploadSuccess: LiveData<Boolean> = _uploadSuccess

    var userUiState by mutableStateOf(UserUiState())
        private set

    fun updateUiState(userDetails: UserDetails) {
        userUiState =
            UserUiState(userDetails = userDetails, isEntryValid = validateInput(userDetails))
    }

    suspend fun saveUser() {
        if (validateInput()) {
            userRepository.insertUser(userUiState.userDetails.toUser())
        }
    }

    private fun validateInput(uiState: UserDetails = userUiState.userDetails): Boolean {
        return with(uiState) {
            benutzername.isNotBlank() && alter.isNotBlank() && wohnort.isNotBlank() && reiseZiele.isNotBlank() && geseheneOrte.isNotBlank()
        }
    }
}


    fun uploadUserData(userData: UserDetails) {
        val user = User(
            userID = userData.id,
            benutzername = userData.benutzername,
            alter = userData.alter,
            wohnort = userData.wohnort,
            reiseZiele = userData.reiseZiele,
            geseheneOrte = userData.geseheneOrte
        )
    }

data class UserUiState(
    val userDetails: UserDetails = UserDetails(),
    val isEntryValid: Boolean = false
)

data class UserDetails(
    val id: Int = 0,
    val benutzername: String = "",
    val alter: String = "",
    val wohnort: String = "",
    val reiseZiele: String = "",
    val geseheneOrte: String ="",
)

fun UserDetails.toUser(): User = User(
    userID = id,
    benutzername = benutzername,
    alter = alter,
    wohnort = wohnort,
    reiseZiele = reiseZiele,
    geseheneOrte = geseheneOrte
)