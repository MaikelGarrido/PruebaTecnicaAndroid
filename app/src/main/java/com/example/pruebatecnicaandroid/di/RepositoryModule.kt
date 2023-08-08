package com.example.pruebatecnicaandroid.di

import com.example.pruebatecnicaandroid.data.repository.TestReposityImpl
import com.example.pruebatecnicaandroid.data.repository.datasource.local.LocalDataSource
import com.example.pruebatecnicaandroid.data.repository.datasource.remote.RemoteDataSource
import com.example.pruebatecnicaandroid.domain.repository.TestRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideTestRepository(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource,
    ): TestRepository {
        return TestReposityImpl(localDataSource,remoteDataSource)
    }


}