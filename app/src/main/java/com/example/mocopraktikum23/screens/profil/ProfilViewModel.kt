package com.example.mocopraktikum23.screens.profil

import com.example.mocopraktikum23.TravelBuddiesViewModel
import com.example.mocopraktikum23.model.service.LoginService

 class ProfilViewModel(logService: LoginService): TravelBuddiesViewModel(logService){
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
     }
 }
