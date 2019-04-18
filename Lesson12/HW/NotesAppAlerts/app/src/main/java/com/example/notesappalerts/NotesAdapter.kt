package com.example.notesappalerts

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class NotesAdapter (val list  : ArrayList<String>) : RecyclerView.Adapter<NotesAdapter.NoteHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NoteHolder {
        val li = LayoutInflater.from(p0.context)
        val inflatedView = li.inflate(R.layout.item_row, p0, false)
        return NoteHolder(inflatedView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(p0: NoteHolder, p1: Int) {
        val currString = list[p1]
        p0.itemView.tvRow.text = currString
    }

    class NoteHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
}
