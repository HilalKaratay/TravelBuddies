package com.example.mocopraktikum23.screens.login

import androidx.compose.runtime.mutableStateOf
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mocopraktikum23.model.navigation.PostOfficeAppRouter
import com.example.mocopraktikum23.model.service.Validierung
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {

  private val TAG = LoginViewModel::class.simpleName
  var loginUIState = mutableStateOf(LoginUiState())
  var allValidationsPassed = mutableStateOf(false)
  var loginInProgress = mutableStateOf(false)

  fun onEvent(event: LoginUiEvent) {
    when (event) {
      is LoginUiEvent.EmailChanged -> {
        loginUIState.value = loginUIState.value.copy(
          email = event.email
        )
      }

      is LoginUiEvent.PasswordChanged -> {
        loginUIState.value = loginUIState.value.copy(
          password = event.password
        )
      }

      is LoginUiEvent.LoginButtonClicked -> {
        login()
      }
    }
    validateLoginUIDataWithRules()
  }

  private fun validateLoginUIDataWithRules() {
    val emailResult = Validierung.validateEmail(
      email = loginUIState.value.email
    )


    val passwordResult = Validierung.validatePasswort(
      passwort= loginUIState.value.password
    )

    loginUIState.value = loginUIState.value.copy(
      emailError = emailResult.status,
      passwordError = passwordResult.status
    )

    allValidationsPassed.value = emailResult.status && passwordResult.status

  }

  private fun login() {

    loginInProgress.value = true
    val email = loginUIState.value.email
    val password = loginUIState.value.password

    FirebaseAuth
      .getInstance()
      .signInWithEmailAndPassword(email, password)
      .addOnCompleteListener {
        Log.d(TAG,"Inside_login_success")
        Log.d(TAG,"${it.isSuccessful}")

        if(it.isSuccessful){
          loginInProgress.value = false
          PostOfficeAppRouter.navigateTo(ScreensNavigations.MenuScreen)
        }
      }
      .addOnFailureListener {
        Log.d(TAG,"Inside_login_failure")
        Log.d(TAG,"${it.localizedMessage}")

        loginInProgress.value = false

      }

  }

}