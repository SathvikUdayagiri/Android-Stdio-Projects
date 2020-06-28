package com.allprojects.teamscoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1,tv2;
    Button b1,b2,b3,b4,b5,b6,b7;
    int a=0,b=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.textView3);
        tv2=findViewById(R.id.textView4);
        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        b5=findViewById(R.id.button5);
        b6=findViewById(R.id.button6);
        b7=findViewById(R.id.button7);
        if(savedInstanceState!=null)
        {
            String co= (String) savedInstanceState.get("c");
            String co1= (String) savedInstanceState.get("c1");
            tv1.setText(co);
            tv2.setText(co1);
            a=Integer.parseInt(co);
            b=Integer.parseInt(co1);
        }
    }
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("c",tv1.getText().toString());
        outState.putString("c1",tv2.getText().toString());
    }
    public void plus1A(View view) {
        a++;
        tv1.setText(a+"");
    }

    public void plus1B(View view) {
        b++;
        tv2.setText(b+"");
    }

    public void plus3A(View view) {
        a+=3;
        tv1.setText(a+"");
    }

    public void plus3B(View view) {
        b+=3;
        tv2.setText(b+"");
    }

    public void plus5A(View view) {
        a+=5;
        tv1.setText(a+"");
    }

    public void plus5B(View view) {
        b+=5;
        tv2.setText(b+"");
    }

    public void reset(View view) {
        a=b=0;
        tv1.setText(a+"");
        tv2.setText(b+"");
    }
}