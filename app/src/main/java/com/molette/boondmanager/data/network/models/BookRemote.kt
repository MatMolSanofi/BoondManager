package com.molette.boondmanager.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Book(
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