package com.allprojects.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tv=findViewById(R.id.textView);
        String s=getIntent().getStringExtra("name");
        tv.setText("Welcome: "+s);
    }
}