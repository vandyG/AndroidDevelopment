package com.example.onclicklistner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.tvHello){
                    Intent i = new Intent(Intent.ACTION_DIAL);
                    startActivity(i);
                }else {
                    Intent i = new Intent(Intent.ACTION_REBOOT);
                    startActivity(i);
                }
            }
        };

        TextView tv = findViewById(R.id.tvHello);
        tv.setOnClickListener(ocl);
        TextView tv1 = findViewById(R.id.tvHello1);
        tv1.setOnClickListener(ocl);
        TextView tv2 = findViewById(R.id.tvHello2);
        tv2.setOnClickListener(ocl);
    }
}
