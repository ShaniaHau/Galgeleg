package com.example.s195477;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.s195477.Model_logik.Model_logik.Contex;
import com.google.gson.Gson;

public class Vundet extends AppCompatActivity implements View.OnClickListener {

    Contex ctx = Contex.getInstance();
    Button spilIgen, highscore;
    TextView vundetTxtView;
    int score;
    Spiller spiller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vundet);

        score = getIntent().getIntExtra("Score", 0);

        vundetTxtView = (TextView) findViewById(R.id.wontxt);
        vundetTxtView.setText("Din score: " + score);

        spilIgen = (Button) findViewById(R.id.spilIgen2);
        spilIgen.setOnClickListener(this);

        highscore = (Button) findViewById(R.id.submit);
        highscore.setOnClickListener(this);

    }

    Svaerhedsgrad svaerhedsgrad = new Svaerhedsgrad();
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.spilIgen2) {
            ctx.startNytSpil();
            Intent spil = new Intent(this, Spil.class);
            spil.putExtra("Score", score);
            startActivity(spil);
        } else if (v.getId() == R.id.submit) {
            Intent highscore = new Intent(this, Highscore.class);

            spiller = new Spiller(svaerhedsgrad.playersname.getText().toString(), score);
            Gson gson = new Gson();
            String spillerInfo = gson.toJson(spiller);
            highscore.putExtra("Spiller", spillerInfo);

            startActivity(highscore);
        }
    }
}