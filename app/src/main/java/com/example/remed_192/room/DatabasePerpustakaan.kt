package com.example.remed_192.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Book::class, Kategori::class], version = 1, exportSchema = false)
abstract class DatabasePerpustakaan : RoomDatabase() {

    abstract fun bookDao(): BookDao
    abstract fun kategoriDao(): KategoriDao

    companion object {
        @Volatile
        private var Instance: DatabasePerpustakaan? = null

        fun getDatabase(context: Context): DatabasePerpustakaan {
            return (com.example.remed_192.room.DatabasePerpustakaan.Companion.Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context, DatabasePerpustakaan::class.java,
                    "perpus_database")
                    .build().also { com.example.remed_192.room.DatabasePerpustakaan.Companion.Instance = it }
            })
        }
    }
}