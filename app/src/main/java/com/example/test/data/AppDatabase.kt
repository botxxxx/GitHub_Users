package com.example.test.data

import androidx.room.*
import android.content.Context
import com.example.test.data.users.UserDao
import com.example.test.data.users.UserData

@Database(entities = [UserData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUsersDao(): UserDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(context, AppDatabase::class.java, "app.db")
                    .fallbackToDestructiveMigration().build().also { instance = it }
            }
        }
    }
}

