package com.molette.boondmanager.data.network

import com.molette.boondmanager.data.network.models.BookRemote
import com.molette.boondmanager.data.network.models.Page
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksAPI {

    companion object{
        private const val ORDER_BY_PARAM = "order"
    }

    @GET("books")
    suspend fun getBooks(
        @Query("$ORDER_BY_PARAM") orderBy: String = "title" // author || title,
    ): Page<BookRemote>
}