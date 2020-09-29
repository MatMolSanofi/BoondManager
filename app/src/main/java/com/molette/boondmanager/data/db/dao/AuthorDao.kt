package com.molette.boondmanager.data.db.dao

import androidx.room.Query
import com.molette.boondmanager.data.db.models.AuthorDb
import com.molette.boondmanager.data.db.models.BookDb
import kotlinx.coroutines.flow.Flow

interface AuthorDao: BaseDao<AuthorDb> {

    @Query("SELECT * FROM authors WHERE author_id = :authorId")
    fun getAuthor(authorId: Long): Flow<BookDb>
}