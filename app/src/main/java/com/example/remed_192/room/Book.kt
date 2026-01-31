package com.example.remed_192.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblBook")
data class Book(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val isBorrowed: Boolean = false,
    val categoryId: Int?
)