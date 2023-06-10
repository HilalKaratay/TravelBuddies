package com.example.mocopraktikum23.screens.profil

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
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
            user.value = repository.getUserStream()
            loading.value = false
        }
    }
}

