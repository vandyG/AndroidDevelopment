package com.example.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newActivity(View view) {

        Intent startIntent = new Intent(this, SecondActivity.class);

        EditText et = findViewById(R.id.etMain);
        String inputString = et.getText().toString();

        //you can also use getBaseContext() instead of this.
        startIntent.putExtra("KEY", inputString);
        startActivity(startIntent);
    }
}
