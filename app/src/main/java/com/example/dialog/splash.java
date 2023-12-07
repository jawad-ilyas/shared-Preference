package com.example.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                Intent intent = new Intent();

                String name = pref.getString("name", "noadmin");
                String password = pref.getString("password", "noadmin");


                if(name == "admin" && password == "admin")
                {

                     intent = new Intent(splash.this, MainActivity.class);
                }
                else
                {
                    intent = new Intent(splash.this, Login.class);
                }
                Toast.makeText(splash.this, name, Toast.LENGTH_SHORT).show();
                Toast.makeText(splash.this, password, Toast.LENGTH_SHORT).show();
                startActivity(intent);




            }
        },5000);
    }
}