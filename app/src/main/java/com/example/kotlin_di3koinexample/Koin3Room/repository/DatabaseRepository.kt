package com.example.kotlin_di3koinexample.Koin3Room.repository

import com.example.kotlin_di3koinexample.Koin3Room.db.NoteDao
import com.example.kotlin_di3koinexample.Koin3Room.db.NoteEntity

class DatabaseRepository(private val dao: NoteDao) {

    suspend fun saveNote(note: NoteEntity) = dao.saveNote(note)
    fun getAllNotes() = dao.getAllNotes()

}