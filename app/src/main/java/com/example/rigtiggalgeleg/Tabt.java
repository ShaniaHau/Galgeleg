package com.example.rigtiggalgeleg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tabt extends AppCompatActivity implements View.OnClickListener {

    Button spilIgen, highscore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabt);

        spilIgen = (Button) findViewById(R.id.spilIgen);
        spilIgen.setOnClickListener(this);

        highscore = (Button) findViewById(R.id.goToHighscore);
        highscore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.spilIgenTabt){
            Intent spil = new Intent(this, Spil.class);
            startActivity(spil);
        }
        else if (v.getId()==R.id.goToHighscore){
            Intent highscore = new Intent(this, Highscore.class);
            startActivity(highscore);
        }
    }
}