package com.example.pruebatecnicaandroid.data.repository

import com.example.appgestion.utils.NetworkResult
import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.data.repository.datasource.local.LocalDataSource
import com.example.pruebatecnicaandroid.data.repository.datasource.remote.RemoteDataSource
import com.example.pruebatecnicaandroid.domain.model.ResponseGetChallenge
import com.example.pruebatecnicaandroid.domain.model.ResponseLogin
import com.example.pruebatecnicaandroid.domain.model.ResponseQuery
import com.example.pruebatecnicaandroid.domain.repository.TestRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TestReposityImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): TestRepository {

    override suspend fun logout() {
        localDataSource.logout()
    }

    override suspend fun insert(user: User) {
        localDataSource.insert(user)
    }

    override fun getUser(): Flow<User> {
        return localDataSource.getUser()
    }

    override fun getUserCount(): Flow<Int> {
        return localDataSource.getUserCount()
    }

    override suspend fun doGetChallenge(
        operation: String,
        username: String
    ): NetworkResult<ResponseGetChallenge> {
        return remoteDataSource.doGetChallenge(operation, username)
    }

    override suspend fun doLogin(
        operation: String,
        username: String,
        accessKey: String
    ): NetworkResult<ResponseLogin> {
        return remoteDataSource.doLogin(operation, username, accessKey)
    }

    override suspend fun doQuery(
        operation: String,
        sessionName: String,
        query: String
    ): NetworkResult<ResponseQuery> {
        return remoteDataSource.doQuery(operation, sessionName, query)
    }


}