package com.example.mocopraktikum23.screens.login


interface LoginEvent {
    fun onEmailChange(newValue: String)
    fun onPasswordChange(newValue: String)
    fun onSignInClick(openAndPopUp: (String, String) -> Unit)
}