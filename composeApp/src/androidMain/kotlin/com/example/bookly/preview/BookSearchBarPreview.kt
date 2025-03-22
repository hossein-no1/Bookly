package com.example.bookly.preview

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookly.book.presentation.book_list.component.BookSearchBar

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BookSearchBarPreview() {
    MaterialTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),
            contentAlignment = Alignment.Center
        ) {
            BookSearchBar(
                modifier = Modifier.fillMaxWidth(),
                searchQuery = "Jetpack Compose",
                onSearchQueryChange = {},
                onImeSearch = {}
            )
        }
    }
}