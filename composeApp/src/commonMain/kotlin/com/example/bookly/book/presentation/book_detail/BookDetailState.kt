package com.example.bookly.book.presentation.book_detail

import com.example.bookly.book.domain.Book

data class BookDetailState(
    val isLoading: Boolean = true,
    val isFavorite: Boolean = false,
    val book: Book? = null
)
