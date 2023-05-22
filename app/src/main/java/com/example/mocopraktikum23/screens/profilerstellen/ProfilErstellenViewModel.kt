package com.example.mocopraktikum23.screens.profilerstellen

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.UUID


class ProfilErstellenViewModel :ViewModel(){
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val usersRef: DatabaseReference = database.getReference("Benutzernamen")

    //Funktion zum hochladen der Benutzerdaten
    fun uploadUserData(userData: UserData) {
        val userId = generateUserId() //
        usersRef.child(userId).setValue(userData)
    }

    //Funktion zum Generieren einer eindeutigen BenutzerID
    private fun generateUserId(): String {
        return UUID.randomUUID().toString()
    }


}

data class UserData(
    val Benutzernamen: String,
    val Alter: Int,
    val Wohnort: String,
    val Reiseziele: List<String>,
    val GeseheneOrte: List<String>
)

fun main () {
    val viewModel = ProfilErstellenViewModel()

//Erstellen einer Instanz der Userdata-Klasse
    val userdata = UserData(
        Benutzernamen = "Mara",
        Alter = 22,
        Wohnort = "Hamburg",
        Reiseziele = listOf("London", "Rom", "Paris"),
        GeseheneOrte = listOf("Big Ben", "Colosseum", "Eiffel Tower")
    )

//Hochladen der Benutzerdaten in der Firebase Datenbank
    viewModel.uploadUserData(userdata)
}
