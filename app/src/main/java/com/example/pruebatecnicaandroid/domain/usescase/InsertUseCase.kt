package com.example.pruebatecnicaandroid.domain.usescase

import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.domain.repository.TestRepository

class InsertUseCase(private val repo: TestRepository) {

    suspend operator fun invoke(user: User) = repo.insert(user)

}