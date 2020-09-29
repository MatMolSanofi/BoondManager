package com.molette.boondmanager.core.di

import com.molette.boondmanager.data.repositories.implementation.AuthorRepositoryImpl
import com.molette.boondmanager.data.repositories.implementation.BookRepositoryImpl
import com.molette.boondmanager.domain.repositories.AuthorRepository
import com.molette.boondmanager.domain.repositories.BookRepository
import com.molette.boondmanager.domain.usecases.GetAuthorDetailsUseCase
import com.molette.boondmanager.domain.usecases.GetBooksUseCase
import com.molette.boondmanager.presentation.details.DetailsViewModel
import com.molette.boondmanager.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var appModule = module {

    // Repositories
    factory<BookRepository> { BookRepositoryImpl(get(), get()) }
    factory<AuthorRepository> { AuthorRepositoryImpl(get()) }

    // ViewModels
    viewModel { HomeViewModel(get()) }
    viewModel { DetailsViewModel(get()) }

    // Use Cases
    factory { GetBooksUseCase(get()) }
    factory { GetAuthorDetailsUseCase(get(), get()) }
}