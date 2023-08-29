package com.example.mocopraktikum23.model

import com.example.mocopraktikum23.R


//optionale Klasse für liste mit User

object UserDataProvider {
    val user = User(
        userid = 1,
        name = "Monty",
        wohnort = "Köln",
        geseheneOrte = "Frankfurt",
        reiseZiele = "Panama",
        userImageId =R.drawable.mailand
    )
    val userList = listOf(
        user,
        User(
            userid = 2,
            name = "Franzi",
            wohnort = "Gummersbach",
            geseheneOrte = "Libanon",
            reiseZiele = "Trabzon",
            userImageId =R.drawable.mailand2

        ),
        User(
            userid = 3,
            name = "Serdar",
            wohnort = "Bergneustadt",
            geseheneOrte = "Istanbul",
            reiseZiele = "Los Angeles",
            userImageId = R.drawable.mailand

        ),
        User(
            userid = 4,
            name = "Mirac",
            wohnort = "Werdohl",
            geseheneOrte = "Rom",
            reiseZiele = "Amsterdam",
            userImageId =R.drawable.mailand2

        ),
    )
}