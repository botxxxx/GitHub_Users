package com.example.test.data.users

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
//    @Query("SELECT * FROM users ORDER BY login COLLATE NOCASE ASC")
//    fun getSource(): PagingSource<Int, UsersData>
//
//    @Query("SELECT * FROM users ORDER BY login COLLATE NOCASE ASC")
//    fun getUser(): Flow<List<UsersData>>
//
//    @Insert
//    fun insert(data: List<UsersData>)
//
//    @Insert
//    suspend fun insert(data: UsersData)
//
//    @Delete
//    suspend fun delete(data: UsersData)
}