package com.example.pruebatecnicaandroid.ui.scaffold

import com.example.pruebatecnicaandroid.domain.model.ResponseQuery

data class ScaffoldState(
    val isLoading: Boolean = false,
    val isError: String = "",
    val isException: Throwable = Throwable(),
    val items: List<ResponseQuery.Result> = emptyList()
)

