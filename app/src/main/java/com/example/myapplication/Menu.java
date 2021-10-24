package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    ImageView back;
    ImageView settings;
    static TextView cups;
    TextView level1;
    TextView level2;
    TextView level3;
    TextView level4;

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

        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        level3 = findViewById(R.id.level3);
        level4 = findViewById(R.id.level4);

        level1.setOnClickListener(v -> {
            startActivity(new Intent(this, PlayActivity.class).putExtra("level", 1));
        });
        level2.setOnClickListener(v -> {
            startActivity(new Intent(this, PlayActivity.class).putExtra("level", 2));
        });
        level3.setOnClickListener(v -> {
            startActivity(new Intent(this, PlayActivity.class).putExtra("level", 3));
        });
        level4.setOnClickListener(v -> {
            startActivity(new Intent(this, PlayActivity.class).putExtra("level", 4));
        });
    }
}