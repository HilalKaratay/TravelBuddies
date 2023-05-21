package com.example.mocopraktikum23.screens.profil

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mocopraktikum23.model.DataOrException
import com.example.mocopraktikum23.model.User
import com.example.mocopraktikum23.repository.UserRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class ProfilViewModel @Inject constructor(
    private val repository: UserRepository
    ) : ViewModel() {

    val user = mutableStateOf<User?>(null)

    var loading = mutableStateOf(false)
    val data: MutableState<DataOrException<List<User>, Exception>> = mutableStateOf(
        DataOrException(
            listOf(),
            Exception(" ")
        )
    )

    init {
        getUser()
    }

    private fun getUser() {
        viewModelScope.launch {
            loading.value = true
            data.value = repository.getUserFromFirestore()
            loading.value = false
        }
    }
}




    /*
    companion object {
        fun getUserDetails(profileViewModel: ProfilViewModel) {
            UserSession.user?.let {
                profileViewModel.user.value
            }
        }
    }


}


@Composable
fun ProfilDatenAnzeige(){


}
*/