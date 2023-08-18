package com.example.mocopraktikum23.model.service

import com.example.mocopraktikum23.model.service.implementierung.AccountServiceImplementation
import com.example.mocopraktikum23.model.service.implementierung.DatenSpeicherimpl
import com.example.mocopraktikum23.model.service.implementierung.LoginServiceImplementation
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleService {
    @Binds
    abstract fun provideAccountService(impl: AccountServiceImplementation): AccountService

    @Binds
    abstract fun provideLogService(impl: LoginServiceImplementation): LoginService

    @Binds
    abstract fun provideStorageService(impl: DatenSpeicherimpl): DatenSpeicher
}

