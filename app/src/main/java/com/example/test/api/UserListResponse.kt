package com.example.test.api

import com.example.test.data.users.UserData

data class UserListResponse(
    val total_count: Int,
    val incomplete_results: Boolean,
    val items: List<UserData>
)