package com.example.mocopraktikum23

import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

interface AuthRepository {
    suspend fun login(NeueGruppeErstellen: String, GruppeBeitreten: String): Resource<FirebaseDatabase>
}