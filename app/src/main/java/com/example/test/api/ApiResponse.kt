package com.example.test.api

import com.example.test.data.users.UsersData
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @field:SerializedName("total_count")
    val total_count: Int,
    @field:SerializedName("incomplete_results")
    val incomplete_results: Boolean,
    @field:SerializedName("items")
    val items: List<UsersData>
)