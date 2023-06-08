package com.example.mocopraktikum23.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version= 1, exportSchema = false)
 abstract class DatabaseUser : RoomDatabase(){

    abstract fun userDAO(): UserDAO
    companion object{
        @Volatile
        private var Instance: DatabaseUser?= null

        fun getDatabase(context: Context): DatabaseUser {
            return Instance ?: synchronized(this) {  //damit keine race conditions entstehen wichtig
                Room.databaseBuilder(context, DatabaseUser::class.java, "User_Database")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}