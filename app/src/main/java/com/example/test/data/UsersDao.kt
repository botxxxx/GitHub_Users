package com.example.test.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Query("SELECT * FROM users ORDER BY name COLLATE NOCASE ASC")
    fun getSource(): PagingSource<Int, UsersData>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUser(userId: Long): Flow<UsersData>

    @Insert
    fun insert(data: List<UsersData>)

    @Insert
    fun insert(data: UsersData)

    @Delete
    fun delete(data: UsersData)
}