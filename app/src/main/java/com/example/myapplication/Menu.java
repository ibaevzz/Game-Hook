package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    ImageView back;
    ImageView settings;
    TextView cups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());

        cups = findViewById(R.id.cups);
        cups.setText(String.valueOf(MainActivity.cups.getInt("cups", 1)));

        settings = findViewById(R.id.settings);
        settings.setOnClickListener(v->{
            startActivity(new Intent(this, Settings.class));
        });
    }
}