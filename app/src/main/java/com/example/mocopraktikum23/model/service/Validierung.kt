package com.example.mocopraktikum23.model.service

object Validierung {
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

    fun validateWohnort(wohnort: String): ValidationResult {
        return ValidationResult(
            (!wohnort.isEmpty() && wohnort.length >= 2)
        )
    }
    fun validateReiseZiele(reiseZiele: String): ValidationResult {
        return ValidationResult(
            (!reiseZiele.isEmpty() && reiseZiele.length >= 2)
        )
    }
    fun validateGeseheneOrte(geseheneOrte: String): ValidationResult {
        return ValidationResult(
            (!geseheneOrte.isEmpty() && geseheneOrte.length >= 2)
        )
    }
}

data class ValidationResult(
    val status: Boolean = false
)