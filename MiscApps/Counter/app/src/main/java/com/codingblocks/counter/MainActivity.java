package com.codingblocks.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseCount(View view){
       count++;
        Log.e("TAG", ""+count);
        System.out.println(count);

        //set the count to the test
        TextView counterText = findViewById(R.id.countTextView);

        counterText.setText(""+count);

    }

    public void decreaseCount(View view){
        count--;
        Log.e("DECREMENT", ""+count);

        TextView decreText = findViewById(R.id.countTextView);

        decreText.setText(""+count);
    }

    public void reset(View view) {
        count = 0;
        Log.e("DECREMENT", ""+count);

        TextView decreText = findViewById(R.id.countTextView);

        decreText.setText(""+count);
    }
}
