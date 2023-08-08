package com.example.pruebatecnicaandroid.data.repository.datasourceImpl

import com.example.pruebatecnicaandroid.data.db.dao.LoginDAO
import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.data.repository.datasource.local.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val loginDAO: LoginDAO): LocalDataSource {
    override fun getUser(): Flow<User> = loginDAO.getUser()
    override fun getUserCount(): Flow<Int> = loginDAO.getUserCount()
    override suspend fun insert(user: User) = loginDAO.insert(user)
    override suspend fun logout() = loginDAO.logout()
}