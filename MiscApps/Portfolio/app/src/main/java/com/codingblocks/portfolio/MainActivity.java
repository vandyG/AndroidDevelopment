package com.codingblocks.portfolio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void facebook(View view) {
        String url = "https://www.facebook.com/vandit.aka.vandy";
        openURL(url);
    }

    public void linkedin(View view) {
        String url = "https://www.linkedin.com/in/vandit-goel-492b66122/";
        openURL(url);
    }

    public void spotify(View view) {
        String url = "https://open.spotify.com/user/bl8nu9ax077bx4d0zm9s8tvxp";
        openURL(url);
    }

    private void openURL(String url){
        Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}
