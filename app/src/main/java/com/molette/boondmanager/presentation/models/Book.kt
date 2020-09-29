package com.molette.boondmanager.presentation.models

import com.molette.boondmanager.data.db.models.BookDb

data class Book(
    val id: Long,
    val title: String,
    val type: String,
    val cover: String,
    val authorId: Long
) {
}

fun BookDb.toBook(): Book{
    return Book(
        id, title, type, cover, authorId
    )
}