package com.example.pruebatecnicaandroid.data.repository.datasource.remote

import com.example.appgestion.utils.NetworkResult
import com.example.pruebatecnicaandroid.domain.model.ResponseGetChallenge
import com.example.pruebatecnicaandroid.domain.model.ResponseLogin
import com.example.pruebatecnicaandroid.domain.model.ResponseQuery

interface RemoteDataSource {

    suspend fun doGetChallenge(operation: String, username: String): NetworkResult<ResponseGetChallenge>
    suspend fun doLogin(operation: String, username: String, accessKey: String): NetworkResult<ResponseLogin>
    suspend fun doQuery(operation: String, sessionName: String, query: String): NetworkResult<ResponseQuery>

}