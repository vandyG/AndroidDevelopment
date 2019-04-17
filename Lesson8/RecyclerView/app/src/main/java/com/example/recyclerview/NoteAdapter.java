package com.example.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder>{

    ArrayList<Note> notes;
    Context ctx;

    public NoteAdapter(ArrayList<Note> notes, Context ctx) {
        this.notes = notes;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int itemView) {
        LayoutInflater li = LayoutInflater.from(ctx);
        View iv = li.inflate(R.layout.item_note, viewGroup, false);

        return new NoteHolder(iv);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int position) {
        Note currNote = notes.get(position);
        noteHolder.tvNote.setText(currNote.getTitle());
        noteHolder.tvTime.setText(currNote.getTime());
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        private TextView tvNote, tvTime;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
            tvNote = itemView.findViewById(R.id.tvNote);
            tvTime = itemView.findViewById(R.id.tvNoteTime);
        }
    }
}
