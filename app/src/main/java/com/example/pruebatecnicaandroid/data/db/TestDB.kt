package com.example.pruebatecnicaandroid.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pruebatecnicaandroid.data.db.dao.LoginDAO
import com.example.pruebatecnicaandroid.data.db.entities.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class TestDB : RoomDatabase() {

    /** DAO'S */
    abstract fun LoginDAO(): LoginDAO

}