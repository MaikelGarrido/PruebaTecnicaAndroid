package com.example.pruebatecnicaandroid.domain.repository

import com.example.appgestion.utils.NetworkResult
import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.domain.model.ResponseGetChallenge
import com.example.pruebatecnicaandroid.domain.model.ResponseLogin
import com.example.pruebatecnicaandroid.domain.model.ResponseQuery
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface TestRepository {

    suspend fun logout()
    suspend fun insert(user: User)
    fun getUser(): Flow<User>
    fun getUserCount(): Flow<Int>

    suspend fun doGetChallenge(operation: String, username: String): NetworkResult<ResponseGetChallenge>
    suspend fun doLogin(operation: String, username: String, accessKey: String) : NetworkResult<ResponseLogin>
    suspend fun doQuery(operation: String, sessionName: String, query: String): NetworkResult<ResponseQuery>

}