package com.example.mocopraktikum23.screens.profil

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mocopraktikum23.model.navigation.AppRouter
import com.example.mocopraktikum23.model.navigation.ScreensNavigations
import com.example.mocopraktikum23.model.service.ValidierungInformationen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProfilInfoViewModel :ViewModel() {

    val db =Firebase.firestore
    val _signedInUser = MutableStateFlow<FirebaseUser?>(null)
    val signedInUser = _signedInUser.asStateFlow()
    var allValidationsPassed = mutableStateOf(false)
    var profilInfoUiState = mutableStateOf(ProfilInfoUiState())
    var speichernProgress = mutableStateOf(false)
    val firebaseDatabase = FirebaseDatabase.getInstance("https://moco-30a5f-default-rtdb.europe-west1.firebasedatabase.app/")
    val databaseReference = firebaseDatabase.getReference("User").push()


    private val TAG = ProfilInfoViewModel::class.simpleName

    fun onEvent(event: ProfilInfoUiEvent) {
        when (event) {
            is ProfilInfoUiEvent.NameChanged -> {
                profilInfoUiState.value = profilInfoUiState.value.copy(
                    name = event.name
                )
                printState()
            }

            is ProfilInfoUiEvent.GeseheneOrteChanged -> {
                profilInfoUiState.value = profilInfoUiState.value.copy(
                    geseheneOrte = event.geseheneOrte
                )
                printState()
            }

            is ProfilInfoUiEvent.ReisezieleChanged -> {
                profilInfoUiState.value = profilInfoUiState.value.copy(
                    reiseZiele = event.reiseziele
                )
                printState()
            }

            is ProfilInfoUiEvent.WohnortChanged -> {
                profilInfoUiState.value = profilInfoUiState.value.copy(
                    wohnort = event.wohnort
                )
                printState()
            }

            is ProfilInfoUiEvent.SpeichernButtonClicked -> {
                speichern()
                AppRouter.navigateTo(ScreensNavigations.MenuScreen)
            }
        }
        validateDataWithRules()
    }

    private fun validateDataWithRules() {
        val nameResult = profilInfoUiState.value.name?.let {
            ValidierungInformationen.validateNameInfo(
                name = it
            )
        }

        val wohnortResult = profilInfoUiState.value.wohnort?.let {
            ValidierungInformationen.validateWohnortInfo(
                wohnort = it
            )
        }

        val reiseZieleResult = profilInfoUiState.value.reiseZiele?.let {
            ValidierungInformationen.validateReiseZieleInfo(
                reiseZiele = it
            )
        }
        val geseheneOrteResult = profilInfoUiState.value.geseheneOrte?.let {
            ValidierungInformationen.validateGeseheneOrteInfo(
                geseheneOrte = it
            )
        }

        Log.d(TAG, "Inside_validateDataWithRules")
        Log.d(TAG, "nameResult= $nameResult")
        Log.d(TAG, "emailResult= $wohnortResult")
        Log.d(TAG, "passwordResult= $reiseZieleResult")
        Log.d(TAG, "passwordResult= $geseheneOrteResult")

        if (nameResult != null) {
            if (wohnortResult != null) {
                if (reiseZieleResult != null) {
                    if (geseheneOrteResult != null) {
                        profilInfoUiState.value = profilInfoUiState.value.copy(
                            nameError = nameResult.status,
                            wohnortError = wohnortResult.status,
                            reiseZieleError = reiseZieleResult.status,
                            geseheneOrteError = geseheneOrteResult.status
                        )
                    }
                }
            }
        }

        if (nameResult != null) {
            if (wohnortResult != null) {
                allValidationsPassed.value =
                    nameResult.status &&  wohnortResult.status
            }
        }

    }
    fun speichern() {
        speichernProgress.value = true
        val name = profilInfoUiState.value.name
        val wohnort = profilInfoUiState.value.wohnort
        val geseheneOrte = profilInfoUiState.value.geseheneOrte
        val reiseZiele = profilInfoUiState.value.reiseZiele

        Log.d(TAG, "Inside_SaveDATA")
        printState()
        //Cloud Store!!!
       /* val userdata= hashMapOf(
            "name" to name,
            "wohnort" to wohnort,
            "geseheneOrte" to geseheneOrte,
            "reiseZiele" to reiseZiele
        )
       db.collection("User").add(userdata)*/
        _signedInUser.value = FirebaseAuth.getInstance().currentUser
        val user =_signedInUser.value
        user?.run {
            val userIdReference = Firebase.database.reference
                .child("User").child(uid)
            val userData = ProfilInfoUiState(name, wohnort,geseheneOrte,reiseZiele)
            userIdReference.setValue(userData)
        }


        //FIRESTORE REALTIME DATABASE
       /* user?.run {
            val userData = ProfilInfoUiState(name, wohnort,geseheneOrte,reiseZiele)
            databaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    databaseReference.setValue(userData)
                }
                override fun onCancelled(error: DatabaseError) {
                    println("Schiefgelaufen")
                }
            })
        }
*/

    /*
        val userData = ProfilInfoUiState(name, wohnort,geseheneOrte,reiseZiele)
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                databaseReference.setValue(userData)
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })*/
    }
    private fun printState() {
        Log.d(TAG, "Inside_printState")
        Log.d(TAG, profilInfoUiState.value.toString())
    }

}