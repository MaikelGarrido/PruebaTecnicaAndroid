package com.example.pruebatecnicaandroid.di

import android.content.Context
import androidx.room.Room
import com.example.pruebatecnicaandroid.data.db.TestDB
import com.example.pruebatecnicaandroid.data.db.dao.LoginDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, TestDB::class.java, "DB_TEST")
            .fallbackToDestructiveMigrationOnDowngrade()
            .build()

    @Singleton
    @Provides
    fun provideLoginDAO(db: TestDB): LoginDAO {
        return db.LoginDAO()
    }

}