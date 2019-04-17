package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Note> notes = new ArrayList<>();
    private EditText etInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final NoteAdapter adapter = new NoteAdapter(notes, this);

        Button btn = findViewById(R.id.btnAdd);

        etInput = findViewById(R.id.etNote);

        RecyclerView rv = findViewById(R.id.rvNotes);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.add(new Note(etInput.getText().toString(), ""+ System.currentTimeMillis()));
                adapter.notifyDataSetChanged();
                etInput.setText("");
            }
        };

        btn.setOnClickListener(ocl);
    }
}
