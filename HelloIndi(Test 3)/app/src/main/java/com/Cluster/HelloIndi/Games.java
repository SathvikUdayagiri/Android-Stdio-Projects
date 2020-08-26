package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
    }


    public void coin(View view) {
        Intent i = new Intent(this, TossGame.class);
        startActivity(i);
    }

    public void dice(View view) {
        Intent i = new Intent(this, Dice.class);
        startActivity(i);
    }

    public void truthordare(View view) {
        Intent i = new Intent(this, TruthOrDare.class);
        startActivity(i);
    }
}