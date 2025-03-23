package com.example.bookly.book.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookApiModel(
    @SerialName("docs") val resultList: List<Result>
){
    @Serializable
    data class Result(
        @SerialName("key") val id: String,
        @SerialName("title") val title: String,
        @SerialName("language") val languageList: List<String>? = null,
        @SerialName("cover_i") val coverAlternativeKey: Int? = null,
        @SerialName("author_key") val authorKeyList: List<String>? = null,
        @SerialName("author_name") val authorNameList: List<String>? = null,
        @SerialName("cover_edition_key") val coverKey: String? = null,
        @SerialName("first_publish_year") val firstPublished: Int? = null,
        @SerialName("ratings_average") val ratingsAverage: Double? = null,
        @SerialName("ratings_count") val ratingsCount: Int? = null,
        @SerialName("number_of_pages_median") val numberOfPages: Int? = null,
        @SerialName("edition_count") val numberOfEditions: Int? = null,
    )

}