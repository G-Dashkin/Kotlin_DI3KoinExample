package com.example.kotlin_di3koinexample.Koin3Room.di

import android.content.Context
import androidx.room.Room
import com.example.kotlin_di3koinexample.Koin3Room.db.NoteDatabase
import com.example.kotlin_di3koinexample.Koin3Room.utils.Constants

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, NoteDatabase::class.java, Constants.NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: NoteDatabase) = db.noteDao()