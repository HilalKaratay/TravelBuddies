package com.example.mocopraktikum23.model.service

object Validierung {


    fun validateVorname(vorname: String): ValidationResult {
        return ValidationResult(
            (!vorname.isNullOrEmpty() && vorname.length >= 2)
        )

    }

    fun validateNachname(nachname: String): ValidationResult {
        return ValidationResult(
            (!nachname.isNullOrEmpty() && nachname.length >= 2)
        )
    }

    fun validateEmail(email: String): ValidationResult {
        return ValidationResult(
            (!email.isNullOrEmpty())
        )
    }

    fun validatePasswort(passwort: String): ValidationResult {
        return ValidationResult(
            (!passwort.isNullOrEmpty() && passwort.length >= 2)
        )
    }

    fun validateWohnort(wohnort: String): ValidationResult {
        return ValidationResult(
            (!wohnort.isNullOrEmpty() && wohnort.length >= 2)
        )
    }
    fun validateReiseZiele(reiseZiele: String): ValidationResult {
        return ValidationResult(
            (!reiseZiele.isNullOrEmpty() && reiseZiele.length >= 2)
        )
    }
    fun validateGeseheneOrte(geseheneOrte: String): ValidationResult {
        return ValidationResult(
            (!geseheneOrte.isNullOrEmpty() && geseheneOrte.length >= 2)
        )
    }

    fun validatePrivacyPolicyAcceptance(statusValue:Boolean):ValidationResult{
        return ValidationResult(
            statusValue
        )
    }

}

data class ValidationResult(
    val status: Boolean = false
)