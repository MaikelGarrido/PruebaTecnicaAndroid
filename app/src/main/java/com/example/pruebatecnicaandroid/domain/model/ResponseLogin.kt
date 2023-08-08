package com.example.pruebatecnicaandroid.domain.model

data class ResponseLogin(
    val success: Boolean,
    val error: Error,
    val result: Result
) {
    data class Result(
        val sessionName: String,
        val userId: String,
        val version: String,
        val vtigerVersion: String
    )

    data class Error(
        val code: String,
        val message: String,
        //val xdebug_message: String
    )
}