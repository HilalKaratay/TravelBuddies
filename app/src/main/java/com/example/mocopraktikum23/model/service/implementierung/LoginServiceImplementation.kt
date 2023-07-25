package com.example.mocopraktikum23.model.service.implementierung

import com.example.mocopraktikum23.model.service.LoginService
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class LoginServiceImplementation  @Inject constructor() : LoginService {
        override fun logNonFatalCrash(throwable: Throwable) =
            Firebase.crashlytics.recordException(throwable)
    }
