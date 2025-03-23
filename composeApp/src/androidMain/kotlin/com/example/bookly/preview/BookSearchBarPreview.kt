package com.example.bookly.preview

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookly.book.presentation.book_list.component.BookSearchBar

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BookSearchBarPreview() {
    SimplePreview {
        BookSearchBar(
            modifier = Modifier.fillMaxWidth(),
            searchQuery = "Jetpack Compose",
            onSearchQueryChange = {},
            onImeSearch = {}
        )
    }
}