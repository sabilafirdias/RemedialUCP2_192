package com.example.remed_192.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Query("SELECT * FROM tblBook ORDER BY title ASC")
    fun getAllBook(): Flow<List<Book>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book: Book)

    @Query("SELECT * FROM tblBook WHERE id = :id")
    fun getBook(id: Int): Flow<Book>

    @Delete
    suspend fun delete(book: Book)

    @Update
    suspend fun update(book: Book)
}