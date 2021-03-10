package com.example.test.data.drama

import com.google.gson.annotations.SerializedName

data class DramaData(
    @field:SerializedName("drama_id")
    val drama_id: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("total_views")
    val total_views: String,
    @field:SerializedName("created_at")
    val created_at: String,
    @field:SerializedName("thumb")
    val thumb: String,
    @field:SerializedName("rating")
    val rating: String
)