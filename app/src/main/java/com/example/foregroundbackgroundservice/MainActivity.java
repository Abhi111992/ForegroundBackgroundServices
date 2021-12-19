package com.example.foregroundbackgroundservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button backg, foreg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foreg = findViewById(R.id.button_2);
        backg = findViewById(R.id.button_1);


        backg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(new Intent(getApplicationContext(), MyService.class));
            }

        });
        foreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                {
                    startService(new Intent(getApplicationContext(), MyService2.class));
                }
                else
                    {
                   Toast.makeText(this, "unable to access", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}