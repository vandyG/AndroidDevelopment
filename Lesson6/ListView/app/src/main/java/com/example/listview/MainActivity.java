package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> arr = new ArrayList<>();

        arr.add("Person1");
        arr.add("Person2");
        arr.add("Person3");
        arr.add("Person4");
        arr.add("Person5");

        ArrayAdapter<String> aa = new ArrayAdapter<>(this,R.layout.row_view,R.id.tvName, arr);

        ListView lv = findViewById(R.id.lv);
        lv.setAdapter(aa);

    }
}
