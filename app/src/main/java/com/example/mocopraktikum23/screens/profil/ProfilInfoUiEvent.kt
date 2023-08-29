package com.example.mocopraktikum23.screens.profil

sealed class ProfilInfoUiEvent{

    data class NameChanged(val name:String) : ProfilInfoUiEvent()
    data class WohnortChanged(val wohnort: String) : ProfilInfoUiEvent()
    data class ReisezieleChanged(val reiseziele: String) : ProfilInfoUiEvent()
    data class GeseheneOrteChanged(val geseheneOrte: String) : ProfilInfoUiEvent()

    object SpeichernButtonClicked : ProfilInfoUiEvent()
}