package com.example.mocopraktikum23.model

import java.lang.Exception

data class Response(
    var name: String= "",
    var alter: String= "",
    var wohnort: String= "",
    var geseheneOrte: String ="",
    var reiseZiele: String= "",
    var exception: Exception? =null
)
