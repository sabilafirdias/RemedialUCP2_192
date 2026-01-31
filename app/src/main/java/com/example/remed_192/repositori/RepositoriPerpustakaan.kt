package com.example.remed_192.repositori

import com.example.remed_192.room.Book
import com.example.remed_192.room.BookDao
import com.example.remed_192.room.Kategori
import com.example.remed_192.room.KategoriDao
import kotlinx.coroutines.flow.Flow

interface RepositoriPerpustakaan {
    fun getAllBookStream(): Flow<List<Book>>
    suspend fun insertBook(book: Book)
    fun getBookStream(id: Int): Flow<Book?>
    suspend fun deleteBook(book: Book)
    suspend fun updateBook(book: Book)

    fun getAllCategoryStream(): Flow<List<Kategori>>
    fun getCategoryStream(id: Int): Flow<Kategori?>
    suspend fun insertCategory(category: Kategori)
    suspend fun updateCategory(category: Kategori)
    suspend fun deleteCategory(category: Kategori)
}

class OfflineRepositoriPerpustakaan(
    private val bookDao: BookDao,
    private val kategoriDao: KategoriDao
) : RepositoriPerpustakaan {
    override fun getAllBookStream(): Flow<List<Book>> = bookDao.getAllBook()
    override suspend fun insertBook(book: Book) = bookDao.insert(book)
    override fun getBookStream(id: Int): Flow<Book?> = bookDao.getBook(id)
    override suspend fun deleteBook(book: Book) = bookDao.delete(book)
    override suspend fun updateBook(book: Book) = bookDao.update(book)

    override fun getAllCategoryStream(): Flow<List<Kategori>> = kategoriDao.getAllCategory()
    override fun getCategoryStream(id: Int): Flow<Kategori?> = kategoriDao.getCategory(id)
    override suspend fun insertCategory(category: Kategori) = kategoriDao.insert(category)
    override suspend fun updateCategory(category: Kategori) = kategoriDao.update(category)
    override suspend fun deleteCategory(category: Kategori) = kategoriDao.delete(category)
}