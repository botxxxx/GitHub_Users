package com.example.test.data.users

import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class UsersData(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = 0,
    @field:SerializedName("login")
    val login: String,
    @field:SerializedName("avatar_url")
    val avatar_url: String,
    @field:SerializedName("avatar_count")
    val avatar_count: String,
    @field:SerializedName("site_admin")
    val site_admin: Boolean,
    @field:SerializedName("url")
    val url: String
) {
    override fun toString() = login
}