package com.example.pruebatecnicaandroid.ui.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appgestion.utils.NetworkResult
import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.domain.usescase.TestUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCases: TestUseCases
) : ViewModel() {

    val user: StateFlow<NetworkResult<User?>> = useCases.getUserUseCase.invoke()
        .map { user -> NetworkResult.Success(user) }
        .catch { e -> NetworkResult.Exception<Throwable>(e) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NetworkResult.Loading(false))

}