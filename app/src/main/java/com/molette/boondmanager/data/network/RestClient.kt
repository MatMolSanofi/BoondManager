package com.molette.boondmanager.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.molette.boondmanager.BuildConfig
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RestClient {

    companion object {
        private val contentType = MediaType.get("application/json")
        private const val CONNECT_TIMEOUT = 10L
        private const val WRITE_TIMEOUT = 1L
        private const val READ_TIMEOUT = 20L

        @OptIn(kotlinx.serialization.UnstableDefault::class)
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .client(createOkHttpClient())
                .baseUrl(BuildConfig.BOOKS_BASE_API)
                .addConverterFactory(
                    Json(configuration = JsonConfiguration(
                        useArrayPolymorphism = true,
                        encodeDefaults = false, ignoreUnknownKeys = true
                    )
                    ).asConverterFactory(contentType))
                .build()
        }

        fun createBooksAPI(retrofit: Retrofit): BooksAPI {
            return retrofit.create(BooksAPI::class.java)
        }

        fun createOkHttpClient(): OkHttpClient {

            val builder = OkHttpClient.Builder()

            //timeOuts
            builder
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)

            builder.retryOnConnectionFailure(true)

            return builder.build()
        }
    }
}