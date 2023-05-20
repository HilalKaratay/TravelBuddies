package com.example.mocopraktikum23.model

data class Beitrag(
    val id: Int,
    var user: User,
    val location: String,
    val images: List<Int>,
    val caption: String?,
)