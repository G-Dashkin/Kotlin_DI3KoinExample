package com.example.kotlin_di3koinexample.Koin2.di

import android.content.Context
import androidx.room.Room
import com.example.kotlin_di3koinexample.Koin2.db.NoteDatabase
import com.example.kotlin_di3koinexample.Koin2.utils.Constants

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, NoteDatabase::class.java, Constants.NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: NoteDatabase) = db.noteDao()