package com.allprojects.inputcontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    RadioButton rb1,rb2;
    CheckBox cb1,cb2,cb3;
    String gender;
    Spinner d,m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.name);
        et2=findViewById(R.id.phone);
        et3=findViewById(R.id.mail);
        et4=findViewById(R.id.password);
        rb1=findViewById(R.id.male);
        rb2=findViewById(R.id.female);
        cb1=findViewById(R.id.java);
        cb2=findViewById(R.id.python);
        cb3=findViewById(R.id.c);
        d=findViewById(R.id.district);
        m=findViewById(R.id.mandal);

        ArrayAdapter<CharSequence> da=ArrayAdapter.createFromResource(this,R.array.district,android.R.layout.simple_spinner_item);
        d.setAdapter(da);
        d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Toast.makeText(MainActivity.this, "Select a district", Toast.LENGTH_SHORT).show();
                    case 1:
                        ArrayAdapter<CharSequence> km=ArrayAdapter.createFromResource(MainActivity.this,R.array.KrishnaMandal,android.R.layout.simple_spinner_item);
                        m.setAdapter(km);
                        break;
                    case 2:
                        ArrayAdapter<CharSequence> gm=ArrayAdapter.createFromResource(MainActivity.this,R.array.GunturMandal,android.R.layout.simple_spinner_item);
                        m.setAdapter(gm);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void submit(View view) {
        String s1,s2,s3,s4,s5;
        if(rb1.isChecked())
        {
            gender=rb1.getText().toString();
        }
        if(rb2.isChecked())
        {
            gender=rb2.getText().toString();
        }
        StringBuilder sb=new StringBuilder();
        if(cb1.isChecked())
        {
            sb.append(cb1.getText().toString()+",");
        }
        if(cb2.isChecked())
        {
            sb.append(cb2.getText().toString()+",");
        }
        if(cb3.isChecked())
        {
            sb.append(cb3.getText().toString()+",");
        }
        String sd=d.getSelectedItem().toString();
        String sm=m.getSelectedItem().toString();
        s1=et1.getText().toString();
        s2=et2.getText().toString();
        s3=et3.getText().toString();
        s4=gender;
        s5=sb.toString();
        if(s1.isEmpty() || s2.isEmpty() || s3.isEmpty() || s4.isEmpty() || s5.isEmpty())
        {
            Toast.makeText(this, "Fill all details", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Intent i=new Intent(MainActivity.this,HomePage.class);
            i.putExtra("name",s1);
            i.putExtra("phoneno",s2);
            i.putExtra("mail",s3);
            i.putExtra("gender",s4);
            i.putExtra("courses",s5);
            startActivity(i);
        }


    }
}