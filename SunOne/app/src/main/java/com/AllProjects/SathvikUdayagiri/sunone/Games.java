package com.AllProjects.SathvikUdayagiri.sunone;

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
        Intent i=new Intent(this,TossGame.class);
        startActivity(i);
    }
}