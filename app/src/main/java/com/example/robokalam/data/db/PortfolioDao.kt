package com.example.robokalam.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PortfolioDao {

    @Query("SELECT * FROM portfolio WHERE email = :email")
    suspend fun getPortfolio(email: String): Portfolio?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(portfolio: Portfolio)
}
