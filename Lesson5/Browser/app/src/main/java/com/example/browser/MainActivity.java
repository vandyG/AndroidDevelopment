package com.example.browser;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void browser(View view) {

        Intent intent = new Intent(getBaseContext(), BrowserActivity.class);

        EditText input = findViewById(R.id.etInput);

        String url = input.getText().toString();

        intent.setData(Uri.parse(url));

        startActivity(intent);
    }
}
