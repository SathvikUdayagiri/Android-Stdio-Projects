package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SintificCalculatorAndConverter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sintific_calculator_and_converter);
    }

    public void calc(View view) {
        Intent i=new Intent(this,StandardCalculator.class);
        startActivity(i);
    }

    public void binaryconverter(View view) {
        Intent i=new Intent(this,BinaryConvertion.class);
        startActivity(i);
    }
}