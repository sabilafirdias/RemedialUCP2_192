package com.example.remed_192.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface KategoriDao {

    @Query("SELECT * FROM tblKategori ORDER BY name ASC")
    fun getAllCategory(): Flow<List<Kategori>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(category: Kategori)

    @Query("SELECT * FROM tblKategori WHERE id = :id")
    fun getCategory(id: Int): Flow<Kategori>

    @Query("SELECT * FROM tblKategori WHERE parentId = :parentId")
    fun getSubCategory(parentId: Int): Flow<List<Kategori>>

    @Delete
    suspend fun delete(category: Kategori)

    @Update
    suspend fun update(category: Kategori)
}