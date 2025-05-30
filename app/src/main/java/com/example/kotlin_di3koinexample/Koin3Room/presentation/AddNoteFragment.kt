package com.example.kotlin_di3koinexample.Koin3Room.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kotlin_di3koinexample.Koin3Room.DatabaseViewModel
import com.example.kotlin_di3koinexample.Koin3Room.db.NoteEntity
import com.example.kotlin_di3koinexample.databinding.FragmentAddNoteBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior.STATE_EXPANDED
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject

class AddNoteFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding

    private val note by lazy { NoteEntity() }
    private val viewModel: DatabaseViewModel by inject()

    private var noteTitle = ""
    private var noteDesc = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (dialog as? BottomSheetDialog)?.behavior?.state = STATE_EXPANDED

        binding?.apply {
            imgClose.setOnClickListener { dismiss() }

            btnSave.setOnClickListener {

                noteTitle = edtTitle.text.toString()
                noteDesc = edtDesc.text.toString()

                if (noteTitle.isEmpty() || noteDesc.isEmpty()) {
                    Snackbar.make(
                        it,
                        "Title and Description cannot be Empty!",
                        Snackbar.LENGTH_SHORT
                    )
                        .show()
                } else {

                    note.noteId = 0
                    note.noteTitle = noteTitle
                    note.noteDesc = noteDesc

                    viewModel.saveNote(note)

                    edtTitle.setText("")
                    edtDesc.setText("")

                    dismiss()
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}