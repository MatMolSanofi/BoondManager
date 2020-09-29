package com.molette.boondmanager.domain.repositories

import com.molette.boondmanager.data.db.models.AuthorDb
import kotlinx.coroutines.flow.Flow

interface AuthorRepository {

    fun getAuthor(authorId: Long): Flow<AuthorDb>
}