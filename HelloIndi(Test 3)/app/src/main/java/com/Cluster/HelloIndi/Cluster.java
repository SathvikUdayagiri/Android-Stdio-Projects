package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;

public class Cluster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluster);
    }

    public void voice(View view) {


        Intent i=new Intent(this,Voice.class);
        startActivity(i);


    }

    public void games(View view) {
        Intent i=new Intent(this,Games.class);
        startActivity(i);
    }

    public void qrcode(View view) {
        Intent i=new Intent(this,QrCode.class);
        startActivity(i);
    }

    public void stenography(View view) {
        startActivity(new Intent(getApplicationContext(), Steganography.class));
    }

    public void calc(View view) {
        Intent i=new Intent(this,SintificCalculatorAndConverter.class);
        startActivity(i);

    }

    public void textencrypt(View view) {
        Intent i=new Intent(this,textencrypt.class);
        startActivity(i);
    }

//    public void websites(View view) {
//        Intent i=new Intent(this,Websites.class);
//        startActivity(i);
//    }
}

