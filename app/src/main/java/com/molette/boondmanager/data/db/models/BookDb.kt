package com.molette.boondmanager.data.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import com.molette.boondmanager.data.network.models.AuthorRemote
import kotlinx.serialization.SerialName

@Entity(tableName = "books")
data class BookDb(
    @PrimaryKey
    @ColumnInfo(name = "book_id")
    val id: Long,
    val title: String,
    val type: String,
    val cover: String,
    val authorId: Long
) {
}