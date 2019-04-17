package com.example.notesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    private ArrayList<Note> notes;
    private Context context;

    public NotesAdapter(ArrayList<Note> notes, Context context) {
        this.notes = notes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Note currNote = notes.get(position);

        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View inflatedView;

        if(convertView == null){
            inflatedView = li.inflate(R.layout.item_row, parent, false);
        }else {
            inflatedView = convertView;
        }

        TextView tvNote = inflatedView.findViewById(R.id.tvNote);
        TextView tvTime = inflatedView.findViewById(R.id.tvTime);

        tvNote.setText(currNote.getNote());
        tvTime.setText(currNote.getTime());

        return inflatedView;
    }
}
