package com.example.bookly.book.data.source.remote

import com.example.bookly.book.data.model.BookApiModel
import com.example.bookly.core.domain.DataError
import com.example.bookly.core.domain.Result

interface RemoteBookDataSource {
    suspend fun searchBooks(
        query: String,
        resultLimit: Int? = null
    ): Result<BookApiModel, DataError.Remote>
}