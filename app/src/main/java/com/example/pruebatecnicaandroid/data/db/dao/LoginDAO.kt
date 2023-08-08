package com.example.pruebatecnicaandroid.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pruebatecnicaandroid.data.db.entities.User
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * FROM user ORDER BY _id")
    fun getUser() : Flow<User>

    @Query("SELECT COUNT(*) FROM user")
    fun getUserCount(): Flow<Int>

    @Query("DELETE FROM user")
    suspend fun logout()


}