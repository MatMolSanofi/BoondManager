package com.molette.boondmanager.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.molette.boondmanager.data.db.models.BookDb
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao: BaseDao<BookDb> {

    @Query("SELECT * FROM books")
    fun getAll(): Flow<List<BookDb>>

    @Query("SELECT * FROM books WHERE book_id = :bookId")
    fun getBook(bookId: Long): Flow<BookDb>

    @Query("SELECT * FROM books WHERE authorId = :authorId")
    fun getBooksFromAuthor(authorId: Long): Flow<List<BookDb>>

    @Query("DELETE FROM books")
    suspend fun clear()
}