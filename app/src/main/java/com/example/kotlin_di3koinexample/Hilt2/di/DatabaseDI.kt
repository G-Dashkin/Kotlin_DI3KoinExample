package com.example.kotlin_di3koinexample.Hilt2.di

import android.content.Context
import androidx.room.Room
import com.example.kotlin_di3koinexample.Hilt2.db.NoteDatabase
import com.example.kotlin_di3koinexample.Hilt2.utils.Constants

fun provideDatabase(context: Context) =
    Room.databaseBuilder(context, NoteDatabase::class.java, Constants.NOTE_DATABASE)
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

fun provideDao(db: NoteDatabase) = db.noteDao()