package com.example.bookly.book.data.model

import kotlinx.serialization.Serializable

@Serializable(with = BookWorkApiModelSerializer::class)
data class BookWorkApiModel(
    val description: String? = null
)