package com.example.test.data.users

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val login: String,
    val avatar_url: String,
    val site_admin: Boolean
)