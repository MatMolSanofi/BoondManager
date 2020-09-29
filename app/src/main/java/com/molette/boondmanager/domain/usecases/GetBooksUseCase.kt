package com.molette.boondmanager.domain.usecases

import com.molette.boondmanager.data.db.models.BookDb
import com.molette.boondmanager.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow

class GetBooksUseCase(
    private val bookRepository: BookRepository
) {

    fun getBooksFromLocal(): Flow<List<BookDb>>{
        return bookRepository.getBooks()
    }

    suspend fun getBooksFromRemote(){
        bookRepository.getBooksRemote()
    }
}