package com.example.bookly.book.data.source.remote

import com.example.bookly.book.data.model.BookApiModel
import com.example.bookly.book.data.model.BookWorkApiModel
import com.example.bookly.core.data.safeCall
import com.example.bookly.core.domain.DataError
import com.example.bookly.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

private const val BASE_URL = "https://openlibrary.org"

class RemoteBookDataSourceImp(
    private val client: HttpClient
) : RemoteBookDataSource {

    override suspend fun searchBooks(
        query: String,
        resultLimit: Int?
    ): Result<BookApiModel, DataError.Remote> {
        return safeCall<BookApiModel> {
            client.get(
                urlString = "$BASE_URL/search.json"
            ) {
                parameter("q", query)
                parameter("limit", resultLimit)
                parameter("language", "eng")
                parameter("fields", "key,title,author_name,author_key,cover_edition_key,cover_i,ratings_average,ratings_count,first_publish_year,language,number_of_pages_median,edition_count")
            }
        }
    }

    override suspend fun getBookDetailList(bookWorkId: String): Result<BookWorkApiModel, DataError.Remote> {
        return safeCall<BookWorkApiModel> {
            client.get(
                urlString = "$BASE_URL/works/$bookWorkId.json"
            )
        }
    }

}