package com.example.robokalam.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "portfolio")
data class Portfolio(
    @PrimaryKey val email: String,
    val username: String,
    val password: String,
    val name: String,
    val college: String,
    val skills: String,
    val projectTitle: String,
    val projectDescription: String
)