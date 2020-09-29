package com.molette.boondmanager.domain.repositories

import com.molette.boondmanager.data.db.models.BookDb
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    fun getBooks(): Flow<List<BookDb>>
    fun getBooksFromAuthor(authorId: Long): Flow<List<BookDb>>
    suspend fun getBooksRemote()
}