package com.molette.boondmanager

import com.molette.boondmanager.data.network.models.AuthorRemote
import com.molette.boondmanager.data.network.models.BookRemote
import com.molette.boondmanager.data.network.models.toBookDb
import com.molette.boondmanager.presentation.models.toBook
import org.hamcrest.core.IsEqual
import org.junit.Assert
import org.junit.Test

class BookMapperUnitTest {

    val authorRemote = AuthorRemote(id = 2, name = "Mathieu Molette", type = "Author", photo = "Photo")
    val bookRemote = BookRemote(
        id = 1,
        title = "Test",
        type = "Book",
        cover = "Test cover",
        author = authorRemote
    )
    val bookDb = bookRemote.toBookDb()

    @Test
    fun bookRemoteMapping_isCorrect(){

        val local = bookRemote.toBookDb()

        Assert.assertThat(local.id, IsEqual(bookRemote.id))
        Assert.assertThat(local.title, IsEqual(bookRemote.title))
        Assert.assertThat(local.type, IsEqual(bookRemote.type))
        Assert.assertThat(local.cover, IsEqual(bookRemote.cover))
        Assert.assertThat(local.authorId, IsEqual(bookRemote.author.id))
    }

    @Test
    fun bookDbMapping_isCorrect(){

        val local = bookDb.toBook()

        Assert.assertThat(local.id, IsEqual(bookDb.id))
        Assert.assertThat(local.title, IsEqual(bookDb.title))
        Assert.assertThat(local.type, IsEqual(bookDb.type))
        Assert.assertThat(local.cover, IsEqual(bookDb.cover))
        Assert.assertThat(local.authorId, IsEqual(bookDb.authorId))
    }
}