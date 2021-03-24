package com.example.test.data.details

data class DetailData(
    val id: Long,
    val login: String,
    val avatar_url: String,
    val name: String,
    val bio: String? = null,
    val site_admin: Boolean,
    val location: String? = null,
    val blog: String? = null
)