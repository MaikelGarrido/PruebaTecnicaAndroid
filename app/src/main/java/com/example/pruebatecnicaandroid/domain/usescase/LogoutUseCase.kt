package com.example.pruebatecnicaandroid.domain.usescase

import com.example.pruebatecnicaandroid.domain.repository.TestRepository

class LogoutUseCase(private val repo: TestRepository) {

    suspend operator fun invoke() = repo.logout()

}