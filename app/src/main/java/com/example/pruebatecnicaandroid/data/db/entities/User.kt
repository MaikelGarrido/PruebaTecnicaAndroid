package com.example.pruebatecnicaandroid.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val sessionName: String,
    val userId: String,
    val version: String,
    val vtigerVersion: String
)
