package com.codingblocks.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int result;
    int first;
    int second;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void divide(View view) {
        EditText s1 = findViewById(R.id.input1);
        EditText s2 = findViewById(R.id.input2);

        first = Integer.parseInt(s1.getText().toString());
        second = Integer.parseInt(s2.getText().toString());

        result = first/second;

        TextView textView = findViewById(R.id.result);

        textView.setText(""+result);
    }

    public void add(View view) {
        EditText s1 = findViewById(R.id.input1);
        EditText s2 = findViewById(R.id.input2);

        first = Integer.parseInt(s1.getText().toString());
        second = Integer.parseInt(s2.getText().toString());

        result = first + second;


        TextView textView = findViewById(R.id.result);

        textView.setText(""+result);
    }

    public void multiply(View view) {
        EditText s1 = findViewById(R.id.input1);
        EditText s2 = findViewById(R.id.input2);

        first = Integer.parseInt(s1.getText().toString());
        second = Integer.parseInt(s2.getText().toString());

        result = first*second;


        TextView textView = findViewById(R.id.result);

        textView.setText(""+result);
    }

    public void subtract(View view) {
        EditText s1 = findViewById(R.id.input1);
        EditText s2 = findViewById(R.id.input2);

        first = Integer.parseInt(s1.getText().toString());
        second = Integer.parseInt(s2.getText().toString());

        result = first - second;


        TextView textView = findViewById(R.id.result);

        textView.setText(""+result);
    }

    public void reset(View view) {
        TextView tv = findViewById(R.id.result);
        tv.setText("0");

        EditText et1 = findViewById(R.id.input1);
        et1.getText().clear();

        EditText et2 = findViewById(R.id.input2);
        et2.getText().clear();
    }
}
