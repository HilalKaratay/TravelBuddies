package com.example.mocopraktikum23.model

data class DataOrException<T, E: Exception?>(
    var data: T? =null,
    var e: E? = null
)