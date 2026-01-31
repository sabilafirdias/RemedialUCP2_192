package com.example.remed_192.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblKategori")
data class Kategori(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val parentId: Int? = null
)