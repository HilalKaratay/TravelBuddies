package com.example.mocopraktikum23.Screens


data class UserDaten(
    var userID:String,
    var name:String,
    var alter: Int,
    var nachname:String,
    var wohnort : String,
    var geseheneOrte : String,
    var reiseZiele: String){

    fun User(
        firstName: String,
        nachname: String,
        wohnort: String,
        geseheneOrte: String,
        alter: Int,
        reiseZiele: String
    ) {
        this.name = firstName
        this.nachname = nachname
        this.wohnort = wohnort
        this.geseheneOrte = geseheneOrte
        this.alter = alter
        this.reiseZiele =reiseZiele
        this.userID =userID
    }







}
