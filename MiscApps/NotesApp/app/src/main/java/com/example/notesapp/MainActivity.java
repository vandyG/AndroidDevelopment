package com.example.notesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity{

    private ArrayList<Note> arr = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etInput = findViewById(R.id.etInput);
        Button btnInput = findViewById(R.id.btnInput);
        ListView lv = findViewById(R.id.listView);

        final NotesAdapter adapter = new NotesAdapter(arr, this);

        lv.setAdapter(adapter);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arr.add(new Note(etInput.getText().toString()));
                etInput.setText("");
                adapter.notifyDataSetChanged();
            }
        };

        btnInput.setOnClickListener(ocl);

    }
}
