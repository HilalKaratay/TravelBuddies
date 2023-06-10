package com.example.mocopraktikum23.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow



@Dao
interface UserDAO : List<User> {
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (user: User)

    @Update
    suspend fun update (user: User)

    @Delete
    suspend fun delete (user: User)

    @Query("SELECT * from user WHERE userID = :userID")
    fun getUser(userID:Int): Flow<User>  //Updatet sich automatisch mit einem Background Thread - es muss nicht sepeart programmiert werden

    @Query("SELECT * from user ORDER BY  name ASC")
    fun getAllUser(): Flow<List<User>>  //Gibt alle User wieder die in der Tabelle/ Entity gespeichert sind

}