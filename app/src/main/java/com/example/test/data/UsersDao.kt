package com.example.test.data

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Query("SELECT * FROM users ORDER BY name COLLATE NOCASE ASC")
    fun getSource(): PagingSource<Int, UsersData>

    @Query("SELECT * FROM users ORDER BY name COLLATE NOCASE ASC")
    fun getUser(): Flow<List<UsersData>>

    @Insert
    fun insert(data: List<UsersData>)

    @Insert
    suspend fun insert(data: UsersData)

    @Delete
    suspend fun delete(data: UsersData)
}