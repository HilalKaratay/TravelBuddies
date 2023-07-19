package com.example.mocopraktikum23.screens.profilerstellen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.service.DatenSpeicher

import com.example.mocopraktikum23.USER_DEFAULT_ID
import javax.inject.Inject

class ProfilErstellenViewModel @Inject constructor(private val datenSpeicher: DatenSpeicher) : ViewModel(),
        (String) -> Unit {

    val user = mutableStateOf(User())
    suspend fun initialize(userId: String) {

        if (userId != USER_DEFAULT_ID) {
            user.value = datenSpeicher.getUser(userId.substring(1, 6)) ?: User()
        }
    }

    fun onTitleChange(newValue: String) {
        user.value = user.value.copy(name = newValue)
    }

    suspend fun onDoneClick(popUpScreen: () -> Unit) {
        val editedUser = user.value
        if (editedUser.id.isBlank()) {
            datenSpeicher.save(editedUser)
        } else {
            datenSpeicher.update(editedUser)
        }
        popUpScreen()

    }

    private fun Int.toClockPattern(): String {
        return if (this < 10) "0$this" else "$this"
    }

    override fun invoke(p1: String) {
        TODO("Not yet implemented")
    }
}


