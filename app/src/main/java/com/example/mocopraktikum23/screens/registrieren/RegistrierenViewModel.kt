package com.example.mocopraktikum23.screens.registrieren

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.mocopraktikum23.model.navigation.PostOfficeAppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
import com.example.mocopraktikum23.model.service.Validierung
import com.example.mocopraktikum23.screens.MenuScreen
import com.google.firebase.auth.FirebaseAuth
class RegistrierenViewModel(): ViewModel() {

    private val TAG = RegistrierenViewModel::class.simpleName

    var RegistrierenUiState = mutableStateOf(RegistrierenUiState())

    var allValidationsPassed = mutableStateOf(false)

    var signUpInProgress = mutableStateOf(false)

    fun onEvent(event: RegistrierenUiEvent) {
        when (event) {
            is RegistrierenUiEvent.FirstNameChanged -> {
                RegistrierenUiState.value = RegistrierenUiState.value.copy(
                    vorname = event.vorname
                )
                printState()
            }

            is RegistrierenUiEvent.EmailChanged -> {
                RegistrierenUiState.value = RegistrierenUiState.value.copy(
                    email = event.email
                )
                printState()

            }


            is RegistrierenUiEvent.PasswortChanged -> {
                RegistrierenUiState.value = RegistrierenUiState.value.copy(
                    passwort = event.passwort
                )
                printState()

            }
            is RegistrierenUiEvent.RegisterButtonClicked -> {
                registrieren()
            }

            is RegistrierenUiEvent.PrivacyPolicyCheckBoxClicked -> {
                RegistrierenUiState.value = RegistrierenUiState.value.copy(
                    privacyPolicyAccepted = event.status
                )
            }

            is RegistrierenUiEvent.GeseheneOrteChanged -> TODO()
            is RegistrierenUiEvent.ReiseZieleChanged -> TODO()
        }
        validateDataWithRules()
    }


    private fun registrieren() {
        Log.d(TAG, "Inside_signUp")
        printState()
        createUserInFirebase(
            email = RegistrierenUiState.value.email,
            password = RegistrierenUiState.value.passwort)
    }

    private fun validateDataWithRules() {
        val nameResult = Validierung.validateVorname(
            vorname = RegistrierenUiState.value.vorname
        )

        val emailResult = Validierung.validateEmail(
            email = RegistrierenUiState.value.email
        )

        val passwortResult = Validierung.validatePasswort(
            passwort = RegistrierenUiState.value.passwort
        )



        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "nameResult= $nameResult")
        Log.d(TAG, "emailResult= $emailResult")
        Log.d(TAG, "passwordResult= $passwortResult")


        RegistrierenUiState.value = RegistrierenUiState.value.copy(
            vornameError = nameResult.status,
            emailError = emailResult.status,
            passwortError = passwortResult.status,
          //  privacyPolicyError = privacyPolicyResult.status
        )


        allValidationsPassed.value = nameResult.status &&
                emailResult.status && passwortResult.status

    }


    private fun printState() {
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, RegistrierenUiState.value.toString())
    }


    private fun createUserInFirebase(email: String, password: String) {
        signUpInProgress.value = true

        FirebaseAuth
            .getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                Log.d(TAG, "Inside_OnCompleteListener")
                Log.d(TAG, " isSuccessful = ${it.isSuccessful}")

                signUpInProgress.value = false
                if (it.isSuccessful) {

                }
            }
            .addOnFailureListener {
                Log.d(TAG, "Inside_OnFailureListener")
                Log.d(TAG, "Exception= ${it.message}")
                Log.d(TAG, "Exception= ${it.localizedMessage}")
            }
    }

}