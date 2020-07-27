package com.AllProjects.SathvikUdayagiri.sunone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.zxing.qrcode.encoder.QRCode;

public class Cluster extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cluster);
    }


    public void voice(View view) {
        Intent i=new Intent(this,voice.class);
        startActivity(i);
    }

    public void games(View view) {
        Intent i=new Intent(this,Games.class);
        startActivity(i);
    }

    public void qrcode(View view) {
        Intent i=new Intent(this, QrCode.class);
        startActivity(i);
    }
}