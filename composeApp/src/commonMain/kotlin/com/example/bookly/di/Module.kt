package com.example.bookly.di

import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.example.bookly.book.data.db.DatabaseFactory
import com.example.bookly.book.data.db.FavoriteBookDatabase
import com.example.bookly.book.data.repository.BookRepositoryImp
import com.example.bookly.book.data.source.remote.RemoteBookDataSource
import com.example.bookly.book.data.source.remote.RemoteBookDataSourceImp
import com.example.bookly.book.domain.BookRepository
import com.example.bookly.book.presentation.SelectedBookViewModel
import com.example.bookly.book.presentation.book_detail.BookDetailViewModel
import com.example.bookly.book.presentation.book_list.BookListViewModel
import com.example.bookly.core.data.HttpClientFactory
import io.ktor.client.HttpClient
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

expect val platformModule: Module

val sharedModule = module {
    single<HttpClient> { HttpClientFactory.create(engine = get()) }
    singleOf(::RemoteBookDataSourceImp).bind<RemoteBookDataSource>()
    singleOf(::BookRepositoryImp).bind<BookRepository>()

    single {
        get<DatabaseFactory>().create()
            .setDriver(BundledSQLiteDriver())
            .build()
    }
    single { get<FavoriteBookDatabase>().favoriteBookDao }

    viewModelOf(::BookListViewModel)
    viewModelOf(::BookDetailViewModel)
    viewModelOf(::SelectedBookViewModel)
}