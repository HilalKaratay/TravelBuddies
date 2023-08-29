package com.example.mocopraktikum23.screens.profil

data class ProfilInfoUiState(
    val name: String?= "",
    val wohnort: String?= "",
    val reiseZiele: String?= "",
    val geseheneOrte: String? ="",

    var nameError :Boolean = false,
    var wohnortError :Boolean = false,
    var geseheneOrteError : Boolean = false,
    var reiseZieleError:Boolean = false){
    constructor() : this(null, null, null, null)}