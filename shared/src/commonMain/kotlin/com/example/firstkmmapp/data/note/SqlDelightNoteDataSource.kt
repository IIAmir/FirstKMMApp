package com.example.firstkmmapp.data.note

import com.example.firstkmmapp.database.NoteDatabase
import com.example.firstkmmapp.domain.note.Note
import com.example.firstkmmapp.domain.note.NoteDataSource
import com.example.firstkmmapp.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(noteDatabase: NoteDatabase) : NoteDataSource {

    private val queries = noteDatabase.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id,
            title = note.title,
            content = note.content,
            colorHex = note.colorHex,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? {
        return queries
            .getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()
    }

    override suspend fun getAllNotes(): List<Note> {
        return queries
            .getAllNotes()
            .executeAsList()
            .map { it.toNote() }
    }

    override suspend fun deleteNoteById(id: Long) {
        queries.deleteNoteById(id)
    }

}