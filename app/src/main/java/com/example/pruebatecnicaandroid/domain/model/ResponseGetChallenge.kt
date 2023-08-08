package com.example.pruebatecnicaandroid.domain.model

data class ResponseGetChallenge(
    val success: Boolean,
    val result: Result
) {
    data class Result(
        val token: String,
        val serverTime: Int,
        val expireTime: Int
    )
}
