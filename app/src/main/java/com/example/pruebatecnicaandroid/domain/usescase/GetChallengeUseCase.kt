package com.example.pruebatecnicaandroid.domain.usescase

import com.example.pruebatecnicaandroid.domain.repository.TestRepository

class GetChallengeUseCase(private val repo: TestRepository) {

    suspend operator fun invoke(operation: String, username:String) = repo.doGetChallenge(operation, username)

}