package com.example.mocopraktikum23.model.service

object ValidierungInformationen {
    fun validateNameInfo(name: String): ValidationResult {
        return ValidationResult(
            (!name.isEmpty() && name.length >= 2)
        )
    }
    fun validateWohnortInfo(wohnort: String): ValidationResult {
        return ValidationResult(
            (!wohnort.isEmpty() && wohnort.length >= 2)
        )
    }
    fun validateReiseZieleInfo(reiseZiele: String): ValidationResult {
        return ValidationResult(
            (!reiseZiele.isEmpty() && reiseZiele.length >= 2)
        )
    }
    fun validateGeseheneOrteInfo(geseheneOrte: String): ValidationResult {
        return ValidationResult(
            (!geseheneOrte.isEmpty() && geseheneOrte.length >= 2)
        )
    }
}
    data class ValidationInformationResult(
        val status: Boolean = false
    )