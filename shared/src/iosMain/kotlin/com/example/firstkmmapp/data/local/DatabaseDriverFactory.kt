package com.example.firstkmmapp.data.local

import com.example.firstkmmapp.database.NoteDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver():SqlDriver {
        return NativeSqliteDriver(NoteDatabase.Schema,"note.db")
    }
}