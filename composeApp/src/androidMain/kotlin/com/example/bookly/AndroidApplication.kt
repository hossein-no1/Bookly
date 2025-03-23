package com.example.bookly

import android.app.Application
import com.example.bookly.di.initKoin
import org.koin.android.ext.koin.androidContext

class AndroidApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@AndroidApplication)
        }
    }

}