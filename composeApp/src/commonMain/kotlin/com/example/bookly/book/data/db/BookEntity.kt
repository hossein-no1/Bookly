package com.example.bookly.book.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookEntity(
    @PrimaryKey(autoGenerate = false) val id: String,
    val title: String,
    val description: String?,
    val cover: String,
    val languageList: List<String>,
    val authorList: List<String>,
    val firstPublished: String?,
    val ratingsAverage: Double?,
    val ratingsCount: Int?,
    val numberOfPages: Int?,
    val numberOfEditions: Int
)
