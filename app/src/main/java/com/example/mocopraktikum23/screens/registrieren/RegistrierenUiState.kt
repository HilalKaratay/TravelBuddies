package com.example.mocopraktikum23.screens.registrieren


data class RegistrierenUiState(
    var vorname: String ="",
    var email: String = "",
    var passwort: String = "",
    var privacyPolicyAccepted :Boolean = false,

    var vornameError :Boolean = false,
    var emailError :Boolean = false,
    var passwortError : Boolean = false,
    var privacyPolicyError:Boolean = false
)
