package com.example.browser;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import java.net.URI;

public class BrowserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        String url = intent.getDataString();
        if(!(url.startsWith("http")||url.startsWith("https"))){
            url = "https://"+url;
        }

        WebView myWebView = new WebView(getBaseContext());
        setContentView(myWebView);


        myWebView.loadUrl(url);

    }
}
