package com.example.bookly.book.presentation.book_list

import com.example.bookly.book.domain.Book
import com.example.bookly.core.presentation.UiText

data class BookListState(
    val searchQuery : String = "Jetpack Compose",
    val searchResultList: List<Book> = emptyList(),
    val favoriteBookList: List<Book> = emptyList(),
    val isLoading: Boolean = false,
    val selectedTabIndex: Int = 0,
    val errorMessage : UiText? = null
)