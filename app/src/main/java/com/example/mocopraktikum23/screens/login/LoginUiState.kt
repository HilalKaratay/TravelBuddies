
package com.example.mocopraktikum23.screens.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",

    var emailError :Boolean = false,
    var passwordError : Boolean = false

)
