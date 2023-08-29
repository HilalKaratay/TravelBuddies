package com.example.mocopraktikum23.model

import com.google.firebase.firestore.DocumentId

data class User(
    val userid: Int = 0,
    val name: String= "",
    val wohnort: String= "",
    val geseheneOrte: String ="",
    val reiseZiele: String= "",
    val userImageId: Int = 0
)
