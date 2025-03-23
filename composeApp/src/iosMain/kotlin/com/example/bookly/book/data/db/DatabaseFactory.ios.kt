package com.example.bookly.book.data.db

import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

actual class DatabaseFactory {
    actual fun create(): RoomDatabase.Builder<FavoriteBookDatabase> {
        val databaseFile = "${documentDirectory}/${FavoriteBookDatabase.DB_NAME}"
        return Room.databaseBuilder<FavoriteBookDatabase>(
            name = databaseFile
        )
    }

    @OptIn(ExperimentalForeignApi::class)
    private val documentDirectory: String
        get() {
            val directory = NSFileManager.defaultManager.URLForDirectory(
                directory = NSDocumentDirectory,
                inDomain = NSUserDomainMask,
                appropriateForURL = null,
                create = false,
                error = null
            )
            return requireNotNull(directory?.path())
        }
}