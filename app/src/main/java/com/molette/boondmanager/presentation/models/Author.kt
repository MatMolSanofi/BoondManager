package com.molette.boondmanager.presentation.models

import com.molette.boondmanager.data.db.models.AuthorDb

data class Author(
    val id: Long,
    val name: String,
    val type: String,
    val photo: String
) {
}

fun AuthorDb.toAuthor(): Author{
    return Author(id, name, type, photo)
}