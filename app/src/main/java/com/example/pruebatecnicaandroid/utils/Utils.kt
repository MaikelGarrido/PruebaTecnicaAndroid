package com.example.pruebatecnicaandroid.utils

import com.example.appgestion.utils.NetworkResult
import com.google.gson.Gson
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T : Any> handleApi(execute: suspend () -> Response<T>): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Error(response.code(), response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(e.code(), e.message())
    } catch (e: Throwable) {
        NetworkResult.Exception(e)
    }
}

suspend fun <T : Any> NetworkResult<T>.onLoading(
    executable: suspend () -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Loading) {
        executable()
    }
}

suspend fun <T : Any> NetworkResult<T>.onSuccess(
    executable: suspend (T) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> NetworkResult<T>.onError(
    executable: suspend (code: Int, message: String?) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Error<T>) {
        executable(code, message)
    }
}

suspend fun <T : Any> NetworkResult<T>.onException(
    executable: suspend (e: Throwable) -> Unit
): NetworkResult<T> = apply {
    if (this is NetworkResult.Exception<T>) {
        executable(e)
    }
}

fun <T> toJson(entity: T): String = Gson().toJson(entity)
fun <A> String.fromJson(type: Class<A>): A { return Gson().fromJson(this, type) }
fun <A> A.toJsonA(): String? { return Gson().toJson(this) }