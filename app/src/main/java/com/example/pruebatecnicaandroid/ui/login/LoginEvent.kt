package com.example.pruebatecnicaandroid.ui.login

sealed class LoginEvent {
    data class LoginChanged(val operation: String, val username: String, val isLoginEnable: Boolean = false): LoginEvent()
    object Login: LoginEvent()
    object Clear: LoginEvent()
}

