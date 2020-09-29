package com.molette.boondmanager.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.serialization.SerialName

@Entity(tableName = "authors")
class AuthorDb(
    @ColumnInfo(name = "author_id")
    val id: Long,
    val name: String,
    val type: String,
    val photo: String
) {
}