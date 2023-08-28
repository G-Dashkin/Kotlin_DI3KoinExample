package com.example.kotlin_di3koinexample.Hilt2.repository

import com.example.kotlin_di3koinexample.Hilt2.db.NoteDao
import com.example.kotlin_di3koinexample.Hilt2.db.NoteEntity

class DatabaseRepository(private val dao: NoteDao) {

    suspend fun saveNote(note: NoteEntity) = dao.saveNote(note)
    fun getAllNotes() = dao.getAllNotes()

}