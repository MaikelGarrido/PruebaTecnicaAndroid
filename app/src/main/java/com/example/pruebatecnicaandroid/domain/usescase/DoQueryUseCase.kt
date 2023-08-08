package com.example.pruebatecnicaandroid.domain.usescase

import com.example.pruebatecnicaandroid.domain.repository.TestRepository

class DoQueryUseCase(private val repo: TestRepository) {

    suspend operator fun invoke(operation: String, sessionName: String, query: String) = repo.doQuery(operation, sessionName, query)

}