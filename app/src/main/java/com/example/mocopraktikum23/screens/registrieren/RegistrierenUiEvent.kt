package com.example.mocopraktikum23.screens.registrieren

sealed class RegistrierenUiEvent{

    data class FirstNameChanged(val vorname:String) : RegistrierenUiEvent()
    data class EmailChanged(val email:String): RegistrierenUiEvent()
    data class PasswortChanged(val passwort: String) : RegistrierenUiEvent()
    data class ReiseZieleChanged(val reiseZiele: String) : RegistrierenUiEvent()
    data class GeseheneOrteChanged(val geseheneOrte: String) : RegistrierenUiEvent()

    data class PrivacyPolicyCheckBoxClicked(val status:Boolean) : RegistrierenUiEvent()

    object RegisterButtonClicked : RegistrierenUiEvent()
}