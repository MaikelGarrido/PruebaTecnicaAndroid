package com.example.pruebatecnicaandroid.ui.login

data class LoginState(
    val isLoading: Boolean = false,
    val isError: String = "",
    val isException: Throwable = Throwable(),
    val successMessage: String = "",
    val operation: String = "getchallenge",
    val username: String = "prueba",
    val isSuccess: Boolean = false,
    val enabled: Boolean = true
)
