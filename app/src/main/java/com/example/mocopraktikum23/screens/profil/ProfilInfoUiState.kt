package com.example.mocopraktikum23.screens.profil

import com.google.firebase.firestore.DocumentId

data class ProfilInfoUiState(
    val name: String?= "",
    val wohnort: String?= "",
    val reiseZiele: String?= "",
    val geseheneOrte: String? ="",


    var nameError :Boolean = false,
    var wohnortError :Boolean = false,
    var geseheneOrteError : Boolean = false,
    var reiseZieleError:Boolean = false
){
    constructor() : this(null, null, null, null)
}