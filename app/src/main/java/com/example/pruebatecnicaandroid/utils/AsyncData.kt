package com.example.pruebatecnicaandroid.utils

import androidx.compose.runtime.Composable
import com.example.appgestion.utils.NetworkResult

@Composable
fun <T> AsyncData(
    resultState: NetworkResult<T?>?,
    loadingContent: @Composable () -> Unit = { /*GenericLoading()*/ },
    errorContent: @Composable () -> Unit = { /*GenericError()*/ },
    exceptionContent: @Composable () -> Unit = { },
    content: @Composable (data: T?) -> Unit
) {
    resultState.let { state ->
        when (state) {
            is NetworkResult.Error -> { errorContent() }
            is NetworkResult.Exception -> { exceptionContent() }
            is NetworkResult.Loading -> { if (state.isLoading) loadingContent() }
            is NetworkResult.Success -> { content(state.data)}
            else -> { content(null) }
        }
    }
}

fun <T> asyncData(
    resultState: NetworkResult<T?>?,
    loadingContent: () -> Unit = { /*GenericLoading()*/ },
    errorContent: () -> Unit = { /*GenericError()*/ },
    exceptionContent: () -> Unit = { },
    content: (data: T?) -> Unit
) {
    resultState.let { state ->
        when (state) {
            is NetworkResult.Error -> { errorContent() }
            is NetworkResult.Exception -> { exceptionContent() }
            is NetworkResult.Loading -> { if (state.isLoading) loadingContent() }
            is NetworkResult.Success -> { content(state.data) }
            else -> { content(null) }
        }
    }
}




