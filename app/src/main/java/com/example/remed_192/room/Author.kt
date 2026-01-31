package com.example.remed_192.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "authors")
data class Author(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)