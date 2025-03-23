package com.example.bookly.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookly.book.domain.Book
import com.example.bookly.book.presentation.book_list.component.BookList

private val mockBookList = (1..100).map {
    Book(
        id = it.toString(),
        title = "Book $it",
        cover = "https://image.com",
        authorList = listOf("Hosen"),
        description = "Description $it",
        languageList = emptyList(),
        firstPublished = null,
        averageRating = 4.67854,
        ratingCount = 5,
        numberOfPages = 100,
        numberOfEditions = 3
    )
}

@Preview
@Composable
fun BookListPreview() {
    SimplePreview {
        BookList(
            bookList = mockBookList,
            onBookClick = {}
        )
    }
}