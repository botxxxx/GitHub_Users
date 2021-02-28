package com.example.test.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RecyclerItemDao {
    @Query("SELECT * FROM recycler_db")
    fun allDataByName(): PagingSource<Int, RecyclerItemData>

    @Insert
    fun insert(data: List<RecyclerItemData>)

    @Insert
    fun insert(data: RecyclerItemData)

    @Delete
    fun delete(data: RecyclerItemData)
}