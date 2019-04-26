package com.example.notesfirebase

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class NoteAdapter (val notes : ArrayList<Note>) : RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteHolder {
        val inflater = LayoutInflater.from(p0.context)
        val inflatedView = inflater.inflate(R.layout.item_row, p0, false)
        return NoteHolder(inflatedView)
    }

    override fun getItemCount(): Int = notes.size

    override fun onBindViewHolder(p0: NoteHolder, p1: Int) {
        val currNote = notes[p1]

        with(p0.itemView){
            tvNote.text = currNote.content
            tvTime.text = currNote.time
            tvTitle.text = currNote.title
        }
    }

    class NoteHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}


