package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    ImageView stopGame;
    TextView level;
    TextView primer;
    EditText otvet;
    TextView otbut;
    ImageView forward;
    LinearLayout plus;
    LinearLayout minus;
    SharedPreferences.Editor edit;
    int lev;
    int p;
    int v;
    int cups = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        lev = getIntent().getIntExtra("level", 0);
        edit = MainActivity.cups.edit();

        stopGame = findViewById(R.id.stop_game);
        stopGame.setOnClickListener(v->{
            edit.putInt("cups", cups);
            edit.apply();
            Menu.cups.setText(String.valueOf(MainActivity.cups.getInt("cups", 1)));
            finish();
        });

        level = findViewById(R.id.level);
        level.setText(lev+" Level");

        primer = findViewById(R.id.primer);
        random();

        otvet = findViewById(R.id.otvet);
        otbut = findViewById(R.id.otbut);
        forward = findViewById(R.id.forward);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);

        forward.setOnClickListener(v1->{
            if(plus.getVisibility()== View.VISIBLE){
                plus.setVisibility(View.INVISIBLE);
            }
            if(minus.getVisibility()== View.VISIBLE){
                minus.setVisibility(View.INVISIBLE);
            }
            if(otvet.getVisibility()== View.INVISIBLE){
                otvet.setVisibility(View.VISIBLE);
            }
            if(otbut.getVisibility()== View.INVISIBLE){
                otbut.setVisibility(View.VISIBLE);
            }
            random();
        });

        otbut.setOnClickListener(v1->{
            if(lev==1){
                if (otvet.getText().toString().equals(String.valueOf(p + v))){
                    plus.setVisibility(View.VISIBLE);
                    cups+=10;
                    Toast.makeText(this, "Все верно", Toast.LENGTH_SHORT).show();
                }else {
                    minus.setVisibility(View.VISIBLE);
                    cups-=10;
                    Toast.makeText(this, "Неверно! Верный ответ "+(p+v), Toast.LENGTH_SHORT).show();
                }
            }else if (lev==2){
                if (otvet.getText().toString().equals(String.valueOf(p - v))){
                    plus.setVisibility(View.VISIBLE);
                    cups+=10;
                    Toast.makeText(this, "Все верно", Toast.LENGTH_SHORT).show();
                }else {
                    minus.setVisibility(View.VISIBLE);
                    cups-=10;
                    Toast.makeText(this, "Неверно! Верный ответ "+(p-v), Toast.LENGTH_SHORT).show();
                }
            }else if (lev==3){
                if (otvet.getText().toString().equals(String.valueOf(p * v))){
                    plus.setVisibility(View.VISIBLE);
                    cups+=10;
                    Toast.makeText(this, "Все верно", Toast.LENGTH_SHORT).show();
                }else {
                    minus.setVisibility(View.VISIBLE);
                    cups-=10;
                    Toast.makeText(this, "Неверно! Верный ответ "+(p*v), Toast.LENGTH_SHORT).show();
                }
            }else if (lev==4){
                if (otvet.getText().toString().equals(String.valueOf(p / v))){
                    plus.setVisibility(View.VISIBLE);
                    cups+=10;
                    Toast.makeText(this, "Все верно", Toast.LENGTH_SHORT).show();
                }else {
                    minus.setVisibility(View.VISIBLE);
                    cups-=10;
                    Toast.makeText(this, "Неверно! Верный ответ "+(p/v), Toast.LENGTH_SHORT).show();
                }
            }
            otvet.setVisibility(View.INVISIBLE);
            v1.setVisibility(View.INVISIBLE);
        });
    }

    private void random(){
        if (lev==1){
            while(true) {
                p = (int) (Math.random() * 20);
                v = (int) (Math.random() * 20);
                if (v!=0||p!=0)break;
            }
            primer.setText(p+" + "+v);
        }else if(lev==2){
            while(true) {
                p = (int) (Math.random() * 20);
                v = (int) (Math.random() * 20);
                if ((v!=0||p!=0)&p-v>=0)break;
            }
            primer.setText(p+" - "+v);
        }else if(lev==3){
            while(true) {
                p = (int) (Math.random() * 20);
                v = (int) (Math.random() * 20);
                if (v!=0||p!=0)break;
            }
            primer.setText(p+" * "+v);
        }else if(lev==4){
            while(true) {
                p = (int) (Math.random() * 20);
                v = (int) (Math.random() * 20);
                if (v==0||p==0)continue;
                if(p%v==0){
                    break;
                }
            }
            primer.setText(p+" / "+v);
        }
    }

    @Override
    public void onBackPressed() {
        edit.putInt("cups", cups);
        edit.apply();
        Menu.cups.setText(String.valueOf(MainActivity.cups.getInt("cups", 1)));
        finish();
    }
}