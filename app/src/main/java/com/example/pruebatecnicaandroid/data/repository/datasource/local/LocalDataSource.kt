package com.example.pruebatecnicaandroid.data.repository.datasource.local

import com.example.pruebatecnicaandroid.data.db.entities.User
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getUser() : Flow<User>
    fun getUserCount(): Flow<Int>
    suspend fun insert(user: User)
    suspend fun logout()
}