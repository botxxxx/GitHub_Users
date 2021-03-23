package com.example.test.data.users

import androidx.paging.PagingSource
import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users ORDER BY login COLLATE NOCASE ASC")
    fun getSource(): PagingSource<Int, UserData>

    @Query("SELECT * FROM users ORDER BY login COLLATE NOCASE ASC")
    fun getUser(): Flow<List<UserData>>

    @Insert
    fun insert(data: List<UserData>)

    @Insert
    suspend fun insert(data: UserData)

    @Query("DELETE FROM users")
    suspend fun delete()
}