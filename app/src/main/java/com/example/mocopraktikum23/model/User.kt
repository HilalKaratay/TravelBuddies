package com.example.mocopraktikum23.model



data class User(
    var userID:Int? =null,
    var name:String,
    var alter: Int,
    var nachname:String,
    var wohnort : String,
    var geseheneOrte : String,
    var reiseZiele: String)
