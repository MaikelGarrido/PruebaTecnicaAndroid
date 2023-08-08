package com.example.pruebatecnicaandroid.di

import com.example.pruebatecnicaandroid.domain.repository.TestRepository
import com.example.pruebatecnicaandroid.domain.usescase.DoLoginUseCase
import com.example.pruebatecnicaandroid.domain.usescase.DoQueryUseCase
import com.example.pruebatecnicaandroid.domain.usescase.GetChallengeUseCase
import com.example.pruebatecnicaandroid.domain.usescase.GetUserUseCase
import com.example.pruebatecnicaandroid.domain.usescase.InsertUseCase
import com.example.pruebatecnicaandroid.domain.usescase.LogoutUseCase
import com.example.pruebatecnicaandroid.domain.usescase.TestUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideTestUseCases(testRepository: TestRepository): TestUseCases {
        return TestUseCases(
            getChallengeUseCase = GetChallengeUseCase(testRepository),
            doLoginUseCase = DoLoginUseCase(testRepository),
            insertUseCase = InsertUseCase(testRepository),
            getUserUseCase = GetUserUseCase(testRepository),
            logoutUseCase = LogoutUseCase(testRepository),
            doQueryUseCase = DoQueryUseCase(testRepository)
        )
    }

}