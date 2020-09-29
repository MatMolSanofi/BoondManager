package com.molette.boondmanager.data.network.models

import com.molette.boondmanager.data.db.models.BookDb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class BookRemote(
    @SerialName("id")
    val id: Long,
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
    @SerialName("cover")
    val cover: String,
    @SerialName("author")
    val author: AuthorRemote
) {
}

fun BookRemote.toBookDb(): BookDb{
    return BookDb(
        id = id,
        title = title,
        type = type,
        cover = cover,
        authorId = author.id
    )
}