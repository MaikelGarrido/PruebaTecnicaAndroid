package com.example.pruebatecnicaandroid.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.domain.usescase.TestUseCases
import com.example.pruebatecnicaandroid.utils.MD5Encryptor
import com.example.pruebatecnicaandroid.utils.onError
import com.example.pruebatecnicaandroid.utils.onException
import com.example.pruebatecnicaandroid.utils.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCases: TestUseCases
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.LoginChanged -> { doLoginChanged(event) }
            LoginEvent.Clear -> { doClear() }
            LoginEvent.Login -> { getChallenge() }
        }
    }

    private fun doLoginChanged(event: LoginEvent.LoginChanged) {
        _state.update {
            it.copy(
                operation = event.operation,
                username = event.username,
                enabled = event.operation.isNotEmpty() && event.username.isNotEmpty()
            )
        }
    }

    private fun getChallenge() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            useCases.getChallengeUseCase.invoke(
                operation = _state.value.operation,
                username = _state.value.username
            ).onSuccess {
                doLogin(it.result.token)
            }.onError { code, message ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = message ?: "Se ha presentado un error"
                    )
                }
            }.onException { e ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        isException = e
                    )
                }
            }
        }
    }

    private fun doLogin(token: String) {
        viewModelScope.launch {
            useCases.doLoginUseCase.invoke(
                operation = "login",
                username = _state.value.username,
                accessKey = MD5Encryptor.encrypt("${token}PX9q5CfKDrOEdNv") // <--- Encriptación MD5 (JAVA)
            ).onSuccess { response ->
                when(response.success) {
                    true -> {
                        val user = User(
                            sessionName = response.result.sessionName,
                            userId = response.result.userId,
                            version = response.result.version,
                            vtigerVersion = response.result.vtigerVersion
                        )
                        useCases.insertUseCase.invoke(user)
                        _state.update { it.copy(isSuccess = true) }
                    }
                    else -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                isError = response.error.message
                            )
                        }
                    }
                }
            }.onError { code, message ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        isError = message ?: "Se ha presentado un error"
                    )
                }
            }.onException { e ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        isException = e
                    )
                }
            }
        }
    }


    private fun doClear() { _state.update { LoginState() } }

}