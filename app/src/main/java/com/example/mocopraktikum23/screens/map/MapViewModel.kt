package com.example.mocopraktikum23.screens.map

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.User
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel @Inject constructor(
    ):ViewModel() {

        val user = mutableStateOf<User?>(null)

        var loading = mutableStateOf(false)


        init {
            getUser()
        }

        private fun getUser() {
            viewModelScope.launch {
                loading.value = true
                loading.value = false
            }
        }
    }
