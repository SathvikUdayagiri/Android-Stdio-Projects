package com.allprojects.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.Name);
        et2=findViewById(R.id.editTextTextPassword2);
    }

    public void register(View view) {
        Intent i=new Intent(this,RegisterPage.class);
        startActivity(i);
    }

    public void login(View view) {
        if(et2.getText().toString().equals("root"))
        {
            Toast.makeText(this,"you are a authorised person",Toast.LENGTH_SHORT).show();
            String st=et1.getText().toString();
            if(st.isEmpty())
            {
                Toast.makeText(this,"please enter name",Toast.LENGTH_SHORT).show();
            }
            else{
                Intent i=new Intent(this,HomePage.class);
                i.putExtra("name",st);
                startActivity(i);
            }
        }
        else
        {
            Toast.makeText(this,"you are not an authorised person",Toast.LENGTH_LONG).show();
        }
    }
}