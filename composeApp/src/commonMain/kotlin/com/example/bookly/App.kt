package com.example.bookly

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.bookly.book.data.repository.BookRepositoryImp
import com.example.bookly.book.data.source.remote.RemoteBookDataSourceImp
import com.example.bookly.book.presentation.book_list.BookListScreen
import com.example.bookly.book.presentation.book_list.BookListViewModel
import com.example.bookly.core.data.HttpClientFactory
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(httpClientEngine : HttpClientEngine) {

    BookListScreen(
        viewModel = remember {
            BookListViewModel(
                bookRepository = BookRepositoryImp(
                    dataSource = RemoteBookDataSourceImp(
                        client = HttpClientFactory.create(engine = httpClientEngine)
                    )
                )
            )
        },
        onBookClick = {}
    )

}