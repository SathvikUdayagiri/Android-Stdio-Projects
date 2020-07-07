package com.allprojects.inputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {
    TextView tv1,tv2,tv3,tv4,tv5;
    String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tv1=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.textView3);
        tv4=findViewById(R.id.textView4);
        tv5=findViewById(R.id.textView5);

        tv1.setText(tv1.getText().toString()+"\n"+getIntent().getStringExtra("name"));
        tv2.setText(tv2.getText().toString()+getIntent().getStringExtra("phoneno"));
        tv3.setText(tv3.getText().toString()+getIntent().getStringExtra("mail"));
        tv4.setText(tv4.getText().toString()+getIntent().getStringExtra("gender"));
        tv5.setText(tv5.getText().toString()+getIntent().getStringExtra("courses"));
    }
}