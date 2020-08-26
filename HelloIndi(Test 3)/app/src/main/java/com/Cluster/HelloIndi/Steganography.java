package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Steganography extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steganography);
    }
    public void encode(View view) {
        startActivity(new Intent(getApplicationContext(), Encode.class));
    }

    public void decode(View view) {
        startActivity(new Intent(getApplicationContext(), Decode.class));
    }
}