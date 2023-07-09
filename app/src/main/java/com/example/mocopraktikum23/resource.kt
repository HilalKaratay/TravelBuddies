package com.example.mocopraktikum23

sealed class Resource <out R> {

    data class Success<out R> (val Result:R) :Resource<R>()
    data class Failure(val exception: Exception) :Resource<Nothing>()
    object Loading  :Resource<Nothing>()

}