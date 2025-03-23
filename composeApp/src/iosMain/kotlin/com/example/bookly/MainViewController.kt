package com.example.bookly

import androidx.compose.ui.window.ComposeUIViewController
import com.example.bookly.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }