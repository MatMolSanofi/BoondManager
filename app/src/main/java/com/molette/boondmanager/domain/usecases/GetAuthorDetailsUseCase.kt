package com.molette.boondmanager.domain.usecases

import com.molette.boondmanager.data.db.models.AuthorDb
import com.molette.boondmanager.data.db.models.BookDb
import com.molette.boondmanager.domain.repositories.AuthorRepository
import com.molette.boondmanager.domain.repositories.BookRepository
import kotlinx.coroutines.flow.Flow

class GetAuthorDetailsUseCase(
    private val bookRepository: BookRepository,
    private val authorRepository: AuthorRepository
) {

    fun getBooksFromAuthor(authorId: Long): Flow<List<BookDb>>{
        return bookRepository.getBooksFromAuthor(authorId)
    }

    fun getAuthor(authorId: Long): Flow<AuthorDb>{

        return authorRepository.getAuthor(authorId)
    }
}