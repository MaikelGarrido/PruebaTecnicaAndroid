package com.example.pruebatecnicaandroid.domain.usescase

import com.example.pruebatecnicaandroid.domain.repository.TestRepository

class GetUserUseCase(private val repo: TestRepository) {

    operator fun invoke() = repo.getUser()
}