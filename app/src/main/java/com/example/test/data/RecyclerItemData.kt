package com.example.test.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RecyclerItemData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String
)