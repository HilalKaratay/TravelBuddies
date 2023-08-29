package com.example.mocopraktikum23.model.service

object Validierung{
    fun validateName(name: String): ValidationResult {
        return ValidationResult(
            (!name.isEmpty() && name.length >= 2)
        )
    }

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (!email.isEmpty())
        )
    }

    fun validatePasswort(passwort: String): ValidationResult {
        return ValidationResult(
            (!passwort.isEmpty() && passwort.length >= 2)
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)