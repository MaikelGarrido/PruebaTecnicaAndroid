package com.example.appgestion.utils

/*
sealed class NetworkResult<T : Any> {
    class Success<T: Any>(val data: T) : NetworkResult<T>()
    class Loading<T: Any> : NetworkResult<T>()
    class Error<T: Any>(val code: Int, val message: String?) : NetworkResult<T>()
    class Exception<T: Any>(val e: Throwable) : NetworkResult<T>()
}*/

sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error<out T>(val code: Int, val message: String?) : NetworkResult<T>()
    data class Exception<out T>(val e: Throwable) : NetworkResult<T>()
    data class Loading<out T>(val isLoading: Boolean) : NetworkResult<T>()
}
