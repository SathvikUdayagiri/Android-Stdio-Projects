package com.AllProjects.counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int a=0;
    TextView tv;
    Button b1,b2,b3,b4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView);
        b1=findViewById(R.id.button1);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        b4=findViewById(R.id.button4);
        if(savedInstanceState!=null)
        {
            String co= (String) savedInstanceState.get("c");
            tv.setText(co);
            a=Integer.parseInt(co);
        }
    }
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("c",tv.getText().toString());
    }
    public void minus(View view) {
        if(a==0)
        {
            Toast.makeText(this,"Minimum value is 0",Toast.LENGTH_SHORT).show();
        }
        else
        {
            a--;
            tv.setText(a+"");
        }

    }

    public void reset(View view) {
        a=0;
        tv.setText(a+"");
    }

    public void toast(View view) {
        Toast.makeText(this,"Your Count is:"+a,Toast.LENGTH_SHORT).show();
    }

    public void plus(View view) {
        a++;
        tv.setText(a+"");
    }
}