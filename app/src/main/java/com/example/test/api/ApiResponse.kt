package com.example.test.api

import com.example.test.data.drama.DramaData
import com.google.gson.annotations.SerializedName


data class ApiResponse(
    @field:SerializedName("data")
    val data: List<DramaData>
)