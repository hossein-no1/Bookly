package com.example.bookly.book.domain

import com.example.bookly.core.domain.Result
import com.example.bookly.core.domain.DataError
import com.example.bookly.core.domain.EmptyResult
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    suspend fun searchBooks(query: String): Result<List<Book>, DataError.Remote>
    suspend fun getBookDescription(bookId: String): Result<String?, DataError>

    fun getFavoriteBooks(): Flow<List<Book>>
    fun isBookFavorite(id: String): Flow<Boolean>
    suspend fun markAsFavorite(book: Book): EmptyResult<DataError.Local>
    suspend fun deleteFromFavorites(id: String)

}