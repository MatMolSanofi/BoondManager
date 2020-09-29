package com.molette.boondmanager.core.di

import com.molette.boondmanager.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

var dbModule = module {
    single {
        AppDatabase.buildDb(androidContext())
    }
}