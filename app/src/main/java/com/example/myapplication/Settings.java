package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    ImageView backs;
    TextView sbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backs = findViewById(R.id.backs);
        backs.setOnClickListener(v->{
            finish();
        });

        sbr = findViewById(R.id.sbr);
        sbr.setOnClickListener(v -> {
            MainActivity.cups.edit().putInt("cups", 0).apply();
            Toast.makeText(Settings.this, "Очки сброшены", Toast.LENGTH_SHORT).show();
        });
    }
}