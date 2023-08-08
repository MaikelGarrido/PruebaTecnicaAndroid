package com.example.pruebatecnicaandroid.domain.usescase

data class TestUseCases(
    val getChallengeUseCase: GetChallengeUseCase,
    val doLoginUseCase: DoLoginUseCase,
    val insertUseCase: InsertUseCase,
    val getUserUseCase: GetUserUseCase,
    val logoutUseCase: LogoutUseCase,
    val doQueryUseCase: DoQueryUseCase
)
