package com.example.bookly

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.bookly.book.presentation.book_list.BookListScreen
import com.example.bookly.book.presentation.book_list.BookListViewModel
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    BookListScreen(
        viewModel = remember { BookListViewModel() },
        onBookClick = {}
    )

}