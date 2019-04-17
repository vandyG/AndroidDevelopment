package com.example.listviewcustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Student> s = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s.add(new Student("Name1", "Surname1", "Contact1", "Address1"));
        s.add(new Student("Name2", "Surname2", "Contact2", "Address2"));
        s.add(new Student("Name3", "Surname3", "Contact3", "Address3"));
        s.add(new Student("Name4", "Surname4", "Contact4", "Address4"));
        s.add(new Student("Name5", "Surname5", "Contact5", "Address5"));




    }
}
