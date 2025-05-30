package com.example.kotlin_di3koinexample.Koin3Room.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_di3koinexample.Koin3Room.DatabaseViewModel
import com.example.kotlin_di3koinexample.Koin3Room.adapter.NoteAdapter
import com.example.kotlin_di3koinexample.databinding.ActivityHilt3Binding
import org.koin.android.ext.android.inject

class HiltActivity3 : AppCompatActivity() {

    private var _binding : ActivityHilt3Binding?=null
    private val binding get() = _binding

    private val noteAdapter by lazy { NoteAdapter() }
    private val viewModel : DatabaseViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHilt3Binding.inflate(layoutInflater)
        setContentView(binding!!.root)

        binding!!.apply {
            btnAddNote.setOnClickListener {
                AddNoteFragment().show(supportFragmentManager, AddNoteFragment().tag)
            }

            viewModel.getAllNotes()
            viewModel.notesList.observe(this@HiltActivity3) {
                if (it.isNotEmpty()) {
                    showEmpty(true)
                    noteAdapter.differ.submitList(it)
                    rvNoteList.apply {
                        layoutManager = LinearLayoutManager(this@HiltActivity3)
                        adapter = noteAdapter
                    }
                } else {
                    showEmpty(false)
                }
            }
        }
    }

    private fun showEmpty(isShow : Boolean) {
        binding!!.apply {
            if(isShow) {
                rvNoteList.visibility = View.VISIBLE
                tvEmptyText.visibility = View.GONE
            } else {
                rvNoteList.visibility = View.GONE
                tvEmptyText.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}