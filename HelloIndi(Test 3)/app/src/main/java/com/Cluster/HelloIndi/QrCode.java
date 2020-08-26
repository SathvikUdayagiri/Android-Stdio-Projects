package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class QrCode extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);
    }

    public void scan(View view) {
        Intent i=new Intent(this,QrScan.class);
        startActivity(i);
    }

    public void generate(View view) {
        Intent i=new Intent(this,QrGenerate.class);
        startActivity(i);
    }
}