package com.example.mocopraktikum23.screens.map

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.TravelBuddiesViewModel
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.model.service.LoginService
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel @Inject constructor(logService: LoginService) : TravelBuddiesViewModel(logService) {

    val users: MutableState<List<User>> = mutableStateOf(emptyList())
    val loading: MutableState<Boolean> = mutableStateOf(false)

    init {
        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            loading.value = true
          //  users.value = userDao.getUser()
            loading.value = false
        }
    }
}
