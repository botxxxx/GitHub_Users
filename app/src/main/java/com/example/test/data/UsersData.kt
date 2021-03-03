package com.example.test.data

import androidx.room.*

@Entity(tableName = "users")
data class UsersData(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val userId: Long,
    val name: String
){
    override fun toString() = name
}