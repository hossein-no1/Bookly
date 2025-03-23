package com.example.bookly.book.data.repository

import com.example.bookly.book.data.mapper.asModel
import com.example.bookly.book.data.source.remote.RemoteBookDataSource
import com.example.bookly.book.domain.Book
import com.example.bookly.book.domain.BookRepository
import com.example.bookly.core.domain.DataError
import com.example.bookly.core.domain.Result
import com.example.bookly.core.domain.map

class BookRepositoryImp(
    private val dataSource: RemoteBookDataSource
) : BookRepository {

    override suspend fun searchBookList(
        query: String,
    ): Result<List<Book>, DataError.Remote> {
        return dataSource
            .searchBooks(query = query)
            .map { bookApiModel ->
                bookApiModel.resultList.map { it.asModel }
            }
    }

}