package com.molette.boondmanager.core.di

import com.molette.boondmanager.data.network.RestClient
import org.koin.dsl.module

var networkModule = module {
    single { RestClient.createOkHttpClient() }
    single { RestClient.getRetrofitInstance() }
    single { RestClient.createBooksAPI(get()) }
}