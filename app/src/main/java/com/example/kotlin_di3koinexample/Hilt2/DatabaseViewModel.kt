package com.example.kotlin_di3koinexample.Hilt2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlin_di3koinexample.Hilt2.db.NoteEntity
import com.example.kotlin_di3koinexample.Hilt2.repository.DatabaseRepository
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DatabaseRepository) : ViewModel() {

    private val _notesList = MutableLiveData<List<NoteEntity>>()
    val notesList: LiveData<List<NoteEntity>>
        get() = _notesList

    fun getAllNotes() = viewModelScope.launch {
        repository.getAllNotes().collect() {
            _notesList.postValue(it)
        }
    }

    fun saveNote(note: NoteEntity) = viewModelScope.launch {
        repository.saveNote(note)
    }


}