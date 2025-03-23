package com.example.test.di;

import android.content.Context;

import com.example.test.data.AppDatabase;
import com.example.test.data.users.UserDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DatabaseModule {

    @Singleton
    @Provides
    public static AppDatabase provideAppDatabase(@ApplicationContext Context context) {
        return AppDatabase.getDatabase(context);
    }

    @Provides
    public static UserDao providePlantDao(AppDatabase appDatabase) {
        return appDatabase.getUsersDao();
    }
}