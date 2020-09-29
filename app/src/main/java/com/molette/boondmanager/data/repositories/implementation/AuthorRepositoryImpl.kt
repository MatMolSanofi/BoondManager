package com.molette.boondmanager.data.repositories.implementation

import com.molette.boondmanager.data.db.AppDatabase
import com.molette.boondmanager.data.db.models.AuthorDb
import com.molette.boondmanager.domain.repositories.AuthorRepository
import kotlinx.coroutines.flow.Flow

class AuthorRepositoryImpl(
    private val localDatasource: AppDatabase
): AuthorRepository {

    override fun getAuthor(authorId: Long): Flow<AuthorDb> {
        return localDatasource.authorDao.getAuthor(authorId)
    }
}