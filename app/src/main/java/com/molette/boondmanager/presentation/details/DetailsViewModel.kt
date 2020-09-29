package com.molette.boondmanager.presentation.details

import androidx.lifecycle.*
import com.molette.boondmanager.data.db.models.AuthorDb
import com.molette.boondmanager.domain.usecases.GetAuthorDetailsUseCase
import com.molette.boondmanager.presentation.models.Author
import com.molette.boondmanager.presentation.models.Book
import com.molette.boondmanager.presentation.models.toAuthor
import com.molette.boondmanager.presentation.models.toBook
import kotlinx.coroutines.flow.map

class DetailsViewModel(
    private val getAuthorDetailsUseCase: GetAuthorDetailsUseCase
): ViewModel() {

    var authorId: MutableLiveData<Long> = MutableLiveData()
    val author: LiveData<Author> = authorId.switchMap {
        getAuthorDetailsUseCase.getAuthor(it).map { it.toAuthor() }.asLiveData()
    }
    val books: LiveData<List<Book>> = authorId.switchMap {
        getAuthorDetailsUseCase.getBooksFromAuthor(it).map { it.map { it.toBook() } }.asLiveData()
    }
}