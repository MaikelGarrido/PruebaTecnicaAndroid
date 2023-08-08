package com.example.pruebatecnicaandroid.ui.scaffold

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgestion.utils.NetworkResult
import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.domain.usescase.TestUseCases
import com.example.pruebatecnicaandroid.ui.login.LoginState
import com.example.pruebatecnicaandroid.utils.onError
import com.example.pruebatecnicaandroid.utils.onException
import com.example.pruebatecnicaandroid.utils.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ScaffoldViewModel @Inject constructor(
    private val useCases: TestUseCases
) :ViewModel() {

    private val _state = MutableStateFlow(ScaffoldState(isLoading = true))
    val state: StateFlow<ScaffoldState> = _state.asStateFlow()

    val user: StateFlow<NetworkResult<User?>> = useCases.getUserUseCase.invoke()
        .map { user -> NetworkResult.Success(user) }
        .catch { e -> NetworkResult.Exception<Throwable>(e) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NetworkResult.Loading(false))

    fun onEvent(event: ScaffoldEvent) {
        when(event) {
            is ScaffoldEvent.QUERY -> { onQuery(event.sessionName) }
        }
    }

    private fun onQuery(sessionName: String) {
        viewModelScope.launch {
            useCases.doQueryUseCase.invoke(
                operation = "query",
                sessionName = sessionName,
                query = "select * from Contacts;"
            ).onSuccess { response ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        items = response.result
                    )
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





}