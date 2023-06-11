package com.example.mocopraktikum23.screens.profil

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

//@HiltViewModel
/*class ProfilViewModel @Inject constructor(
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
}*/
 class ProfilViewModel(createSavedStateHandle: SavedStateHandle) : ViewModel(){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
     }
 }
//data class ProfilUiState(val userDetails: UserDetails = UserDetails())

