package com.example.mocopraktikum23.screens.login

import androidx.compose.runtime.mutableStateOf
import com.example.mocopraktikum23.LOGIN_SCREEN
import com.example.mocopraktikum23.MENU_SCREEN
import com.example.mocopraktikum23.TravelBuddiesViewModel
import com.example.mocopraktikum23.model.service.AccountService
import com.example.mocopraktikum23.model.service.LoginService
import com.example.mocopraktikum23.model.snackbar.SnackbarManager
import com.example.mocopraktikum23.screens.registrieren.isValidEmail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject



@HiltViewModel
class LoginViewModel @Inject constructor(
  private val accountService: AccountService,
  logService: LoginService
) : TravelBuddiesViewModel(logService) {
  var uiState = mutableStateOf(LoginUiState())
    private set

  private val email
    get() = uiState.value.email
  private val password
    get() = uiState.value.password

  fun onEmailChange(newValue: String) {
    uiState.value = uiState.value.copy(email = newValue)
  }

  fun onPasswordChange(newValue: String) {
    uiState.value = uiState.value.copy(password = newValue)
  }

  fun onSignInClick(openAndPopUp: (String, String) -> Unit) {
    if (!email.isValidEmail()) {
      SnackbarManager.showMessage("Email ist nicht korrekt")
      return
    }

    if (password.isBlank()) {
      SnackbarManager.showMessage("Das Passwort ist nicht korrekt")
      return
    }

    launchCatching {
      accountService.authenticate(email, password)
      openAndPopUp(MENU_SCREEN, LOGIN_SCREEN)
    }
  }
}
