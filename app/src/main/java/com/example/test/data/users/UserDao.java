package com.example.test.data.users;

import androidx.lifecycle.LiveData;
import androidx.paging.PagingSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("SELECT * FROM users ORDER BY login COLLATE NOCASE ASC")
    PagingSource<Integer, UserData> getSource();

    @Query("SELECT * FROM users ORDER BY login COLLATE NOCASE ASC")
    LiveData<List<UserData>> getUser();

    @Insert
    void insert(List<UserData> data);

    @Insert
    void insert(UserData data);

    @Query("DELETE FROM users")
    void delete();
}