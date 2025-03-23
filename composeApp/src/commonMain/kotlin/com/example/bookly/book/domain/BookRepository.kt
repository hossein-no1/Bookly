package com.example.bookly.book.domain

import com.example.bookly.core.domain.Result
import com.example.bookly.core.domain.DataError

interface BookRepository {

    suspend fun searchBookList(
        query: String,
    ): Result<List<Book>, DataError.Remote>

}