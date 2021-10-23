package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences log;
    public static SharedPreferences cups;
    public static SharedPreferences.Editor editCup;
    final String sp = "LOG";

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        log = getSharedPreferences(sp, MODE_PRIVATE);
        cups = getSharedPreferences("CUPS", MODE_PRIVATE);

        if(!cups.contains("cups")){
            editCup = cups.edit();
            editCup.putInt("cups", 0);
            editCup.apply();
        }

        if(!log.contains("log")){
            SharedPreferences.Editor edit = log.edit();
            edit.putBoolean("log", true);
            edit.apply();
            setContentView(R.layout.start);
            ImageView close = findViewById(R.id.close);
            close.setOnClickListener(v -> {
                setContentView(R.layout.activity_main);

                TextView go = findViewById(R.id.go);

                go.setOnClickListener(c -> {
                    Intent intent = new Intent(MainActivity.this, Menu.class);
                    startActivity(intent);
                    finish();
                });
            });
        }else{
            setContentView(R.layout.activity_main);

            TextView go = findViewById(R.id.go);

            go.setOnClickListener(v -> {
                Intent intent = new Intent(MainActivity.this, Menu.class);
                startActivity(intent);
                finish();
            });
        }
    }
}