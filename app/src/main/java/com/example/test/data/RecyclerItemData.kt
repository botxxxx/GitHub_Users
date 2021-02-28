package com.example.test.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recycler_db")
data class RecyclerItemData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
){
    override fun toString() = name
}