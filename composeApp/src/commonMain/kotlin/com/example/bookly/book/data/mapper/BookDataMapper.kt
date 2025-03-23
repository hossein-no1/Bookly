package com.example.bookly.book.data.mapper

import com.example.bookly.book.data.model.BookApiModel
import com.example.bookly.book.domain.Book

val BookApiModel.Result.asModel : Book
    get() = Book(
        id = id.substringAfterLast("/"),
        title = title,
        cover = if(coverKey != null) {
            "https://covers.openlibrary.org/b/olid/${coverKey}-L.jpg"
        } else {
            "https://covers.openlibrary.org/b/id/${coverAlternativeKey}-L.jpg"
        },
        authorList = authorNameList ?: emptyList(),
        description = null,
        languageList = languageList ?: emptyList(),
        firstPublished = firstPublished.toString(),
        averageRating = ratingsAverage,
        ratingCount = ratingsCount,
        numberOfPages = numberOfPages,
        numberOfEditions = numberOfEditions ?: 0
    )