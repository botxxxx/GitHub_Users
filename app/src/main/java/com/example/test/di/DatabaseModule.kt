package com.example.test.data.di

import android.content.Context
import com.example.test.data.users.AppDatabase
import com.example.test.data.users.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getDatabase(context)
    }

    @Provides
    fun providePlantDao(appDatabase: AppDatabase): UsersDao {
        return appDatabase.getUsersDao()
    }
}
