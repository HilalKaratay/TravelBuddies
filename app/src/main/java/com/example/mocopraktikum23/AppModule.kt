package com.example.mocopraktikum23


import com.google.firebase.firestore.FirebaseFirestore.*
import com.google.firebase.functions.dagger.Module
import com.google.firebase.functions.dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.mocopraktikum23.util.Constants.Benutzerdaten
import com.example.mocopraktikum23.util.Constants.NAME_PROPERTY

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideQueryUsers() = getInstance()
        .collection("Benutzerdaten")

}