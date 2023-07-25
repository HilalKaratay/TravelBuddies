package com.example.mocopraktikum23.model

import com.google.firebase.firestore.DocumentId

data class User(
    @DocumentId val id: String = "",
    val userid: Int = 0,
    val name: String= "",
    val alter: String= "",
    val wohnort: String= "",
    val geseheneOrte: String ="",
    val reiseZiele: String= "",
    val isAnonymous: Boolean = true
)
