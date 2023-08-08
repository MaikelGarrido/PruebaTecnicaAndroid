package com.example.pruebatecnicaandroid.data.repository.datasourceImpl

import com.example.appgestion.utils.NetworkResult
import com.example.pruebatecnicaandroid.data.api.API
import com.example.pruebatecnicaandroid.data.repository.datasource.remote.RemoteDataSource
import com.example.pruebatecnicaandroid.domain.model.ResponseGetChallenge
import com.example.pruebatecnicaandroid.domain.model.ResponseLogin
import com.example.pruebatecnicaandroid.domain.model.ResponseQuery

class RemoteDataSourceImpl(private val api: API): RemoteDataSource {

    override suspend fun doGetChallenge(
        operation: String,
        username: String
    ): NetworkResult<ResponseGetChallenge> {
        return api.doGetChallenge(operation, username)
    }

    override suspend fun doLogin(
        operation: String,
        username: String,
        accessKey: String
    ): NetworkResult<ResponseLogin> {
        return api.doLogin(operation, username, accessKey)
    }

    override suspend fun doQuery(
        operation: String,
        sessionName: String,
        query: String
    ): NetworkResult<ResponseQuery> {
        return api.doQuery(operation, sessionName, query)
    }


}