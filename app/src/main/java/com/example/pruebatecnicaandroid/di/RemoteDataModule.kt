package com.example.pruebatecnicaandroid.di

import com.example.pruebatecnicaandroid.data.api.API
import com.example.pruebatecnicaandroid.data.repository.datasource.remote.RemoteDataSource
import com.example.pruebatecnicaandroid.data.repository.datasourceImpl.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Singleton
    @Provides
    fun provideMoviesRemoteDataSource(api: API): RemoteDataSource {
        return RemoteDataSourceImpl(api)
    }
}
