package com.example.mocopraktikum23.model
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users") //Name der angelegten Tabelle
data class User(
    @PrimaryKey(autoGenerate = true) //Zeichnet die USERID als einen PRIMARYKEY aus!
    val userID: Int = 0,
    val benutzername: String,
    val alter: String,
    val wohnort: String,
    val geseheneOrte: String,
    val reiseZiele: String
)
