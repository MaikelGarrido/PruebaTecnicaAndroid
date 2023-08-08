package com.example.pruebatecnicaandroid.domain.usescase

import com.example.pruebatecnicaandroid.domain.repository.TestRepository

class DoLoginUseCase(private val repo: TestRepository) {

    suspend operator fun invoke(operation: String, username:String, accessKey: String) = repo.doLogin(operation, username, accessKey)

}