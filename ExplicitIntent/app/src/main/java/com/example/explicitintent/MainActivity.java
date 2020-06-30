package com.example.explicitintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.username);
    }

    public void submit(View view) {

        String st=et.getText().toString();
        if(st.isEmpty())
        {
            Toast.makeText(this,"please enter name",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent i=new Intent(this,SecondActivity.class);
            i.putExtra("name",st);
            startActivity(i);
        }

    }
}