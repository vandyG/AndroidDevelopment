package com.example.notesfirebase

import android.app.Service
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog_view.*
import kotlinx.android.synthetic.main.dialog_view.view.*

class MainActivity : AppCompatActivity() {

    private val notes = arrayListOf<Note>()

    private val dialogView by lazy {
        layoutInflater.inflate(R.layout.dialog_view, null, false)
    }

    private val noteAlert by lazy {
        AlertDialog.Builder(this).setTitle("New Note").setView(dialogView).setCancelable(false).setNegativeButton("Cancel"){dialog, _->
            val note = Note(dialogView.etTitle.text.toString(), etNote.text.toString(), System.currentTimeMillis().toString())

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvNotes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapter = NoteAdapter(notes)
        rvNotes.adapter = adapter

        fab.setOnClickListener{
            noteAlert.show
        }
    }
}
