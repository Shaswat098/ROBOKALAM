package com.example.robokalam.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Portfolio::class], version = 2)
abstract class PortfolioDatabase : RoomDatabase() {
    abstract fun dao(): PortfolioDao

    companion object {
        private var INSTANCE: PortfolioDatabase? = null

        fun getDb(context: Context): PortfolioDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PortfolioDatabase::class.java,
                    "portfolio_db"
                )
                    .fallbackToDestructiveMigration()  // Add this line
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
