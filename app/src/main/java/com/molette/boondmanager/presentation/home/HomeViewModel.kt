package com.molette.boondmanager.presentation.home

import androidx.lifecycle.*
import com.molette.boondmanager.domain.usecases.GetBooksUseCase
import com.molette.boondmanager.presentation.models.Book
import com.molette.boondmanager.presentation.models.toBook
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {

    val books: LiveData<List<Book>> = getBooksUseCase.getBooksFromLocal().map { it.map { it.toBook() } }.asLiveData()

    init {
        viewModelScope.launch {
            getBooksUseCase.getBooksFromRemote()
        }
    }
}