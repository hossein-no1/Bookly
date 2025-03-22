package com.example.bookly.book.domain

data class Book(
    val id: String,
    val title: String,
    val cover: String,
    val authorList: List<String>,
    val description: String?,
    val languageList: List<String>,
    val firstPublished: String?,
    val averageRating: Double?,
    val ratingCount: Int?,
    val numberOfPages: Int?,
    val numberOfEditions: Int
)
