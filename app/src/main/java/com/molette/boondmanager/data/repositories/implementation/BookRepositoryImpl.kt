package com.molette.boondmanager.data.repositories.implementation

import android.util.Log
import com.molette.boondmanager.data.db.AppDatabase
import com.molette.boondmanager.data.db.models.BookDb
import com.molette.boondmanager.data.network.BooksAPI
import com.molette.boondmanager.data.network.models.toAuthorDb
import com.molette.boondmanager.data.network.models.toBookDb
import com.molette.boondmanager.domain.repositories.BookRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class BookRepositoryImpl(
    private val localDatasource: AppDatabase,
    private val remoteDatasource: BooksAPI
): BookRepository {

    override fun getBooks(): Flow<List<BookDb>> {
        return localDatasource.bookDao.getAll()
    }

    override fun getBooksFromAuthor(authorId: Long): Flow<List<BookDb>> {
        return localDatasource.bookDao.getBooksFromAuthor(authorId)
    }

    override suspend fun getBooksRemote() {
        withContext(Dispatchers.IO){
            try {
                val booksRemote = remoteDatasource.getBooks().data
                booksRemote.forEach {
                    localDatasource.authorDao.insert(it.author.toAuthorDb())
                    localDatasource.bookDao.insert(it.toBookDb())
                }
            }catch (e: Exception){
                Log.e("getBooksRemote", e.toString())
            }
        }
    }
}