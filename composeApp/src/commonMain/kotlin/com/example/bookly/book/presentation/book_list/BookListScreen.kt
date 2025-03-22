package com.example.bookly.book.presentation.book_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.example.bookly.book.domain.Book
import com.example.bookly.book.presentation.book_list.component.BookSearchBar
import com.example.bookly.core.presentation.DarkBlue
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun BookListScreen(
    modifier: Modifier = Modifier,
    viewModel: BookListViewModel = koinViewModel(),
    onBookClick: (Book) -> Unit
) {

    val state by viewModel.state.collectAsState()

    Content(
        modifier = modifier,
        searchQuery = state.searchQuery,
        onAction = {
            when (it) {
                is BookListAction.OnBookClick -> onBookClick(it.book)
                else -> viewModel.onAction(action = it)
            }
        }
    )

}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onAction: (BookListAction) -> Unit
) {

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = DarkBlue)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BookSearchBar(
            modifier = Modifier
                .widthIn(max = 400.dp)
                .fillMaxWidth()
                 .padding(all = 16.dp),
            searchQuery = searchQuery,
            onSearchQueryChange = {
                onAction(BookListAction.OnSearchQueryChange(it))
            },
            onImeSearch = {
                keyboardController?.hide()
            }
        )
    }

}