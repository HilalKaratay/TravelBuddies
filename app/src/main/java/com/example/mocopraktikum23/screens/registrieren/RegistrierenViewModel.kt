package com.example.mocopraktikum23.screens.registrieren

import android.util.Patterns
import androidx.compose.runtime.mutableStateOf
import javax.inject.Inject
import com.example.mocopraktikum23.MENU_SCREEN
import com.example.mocopraktikum23.TravelBuddiesViewModel
import com.example.mocopraktikum23.REGISTRIEREN_SCREEN
import com.example.mocopraktikum23.model.service.AccountService
import com.example.mocopraktikum23.model.service.LoginService
import com.example.mocopraktikum23.model.snackbar.SnackbarManager
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Pattern

@HiltViewModel
class RegistrierenViewModel @Inject constructor(
    private val accountService: AccountService,
    logService: LoginService): TravelBuddiesViewModel(logService){
    var uiState = mutableStateOf(RegistrierenUiState())
        private set

    private val email
        get() = uiState.value.email
    private val password
        get() = uiState.value.passwort

    fun onEmailChange(newValue: String) {
        uiState.value = uiState.value.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState.value = uiState.value.copy(passwort = newValue)
    }

    fun onNameChange(newValue: String) {
        uiState.value = uiState.value.copy(name = newValue)
    }
    fun onWohnortChange(newValue: String) {
        uiState.value = uiState.value.copy(wohnort = newValue)
    }
    fun onreiseZieleChange(newValue: String) {
        uiState.value = uiState.value.copy(reiseZiele = newValue)
    }
    fun ongesehenOrteChange(newValue: String) {
        uiState.value = uiState.value.copy(geseheneOrte = newValue)
    }

    fun onSignUpClick(openAndPopUp: (String, String) -> Unit) {
        if (!email.isValidEmail()) {
            SnackbarManager.showMessage("Email ist nicht richtig")
            return
        }

        if (!password.isValidPassword()) {
            SnackbarManager.showMessage("Passwort ist nicht richtig")
            return
        }

        launchCatching {
            accountService.linkAccount(email, password)
            openAndPopUp(MENU_SCREEN, REGISTRIEREN_SCREEN)
        }
    }
}



private const val MIN_PASS_LENGTH = 6
private const val PASS_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{4,}$"

fun String.isValidEmail(): Boolean {
    return this.isNotBlank() && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String.isValidPassword(): Boolean {
    return this.isNotBlank() &&
            this.length >= MIN_PASS_LENGTH &&
            Pattern.compile(PASS_PATTERN).matcher(this).matches()
}

fun String.passwordMatches(repeated: String): Boolean {
    return this == repeated
}

fun String.idFromParameter(): String {
    return this.substring(1, this.length - 1)
}
