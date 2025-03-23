package com.example.bookly.di

import com.example.bookly.book.data.db.DatabaseFactory
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single { Darwin.create() }
        single { DatabaseFactory() }
    }