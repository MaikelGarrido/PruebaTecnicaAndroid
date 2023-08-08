package com.example.pruebatecnicaandroid.data.api

import com.example.appgestion.utils.NetworkResult
import com.example.pruebatecnicaandroid.domain.model.ResponseGetChallenge
import com.example.pruebatecnicaandroid.domain.model.ResponseLogin
import com.example.pruebatecnicaandroid.domain.model.ResponseQuery
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface API {

    @GET("webservice.php")
    suspend fun doGetChallenge(
        @Query("operation") operation: String,
        @Query("username") username: String
    ): NetworkResult<ResponseGetChallenge>

    @FormUrlEncoded
    @POST("webservice.php")
    suspend fun doLogin(
        @Field("operation") operation: String,
        @Field("username") username: String,
        @Field("accessKey") accessKey: String
    ): NetworkResult<ResponseLogin>

    @GET("webservice.php")
    suspend fun doQuery(
        @Query("operation") operation: String,
        @Query("sessionName") sessionName: String,
        @Query("query") query: String
    ): NetworkResult<ResponseQuery>

}