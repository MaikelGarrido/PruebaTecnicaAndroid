package com.example.pruebatecnicaandroid.di

import com.example.pruebatecnicaandroid.data.db.dao.LoginDAO
import com.example.pruebatecnicaandroid.data.repository.datasource.local.LocalDataSource
import com.example.pruebatecnicaandroid.data.repository.datasourceImpl.LocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideLocalDataSource(loginDAO: LoginDAO): LocalDataSource {
        return LocalDataSourceImpl(loginDAO)
    }

}
