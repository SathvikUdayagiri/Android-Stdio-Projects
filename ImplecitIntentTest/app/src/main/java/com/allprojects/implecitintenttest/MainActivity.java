package com.allprojects.implecitintenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
    }

    public void openURL(View view) {
        Uri u= Uri.parse("https://www.google.com");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void call(View view) {
        Uri u=Uri.parse("tel:8888888888");
        Intent i=new Intent(Intent.ACTION_DIAL,u);
        startActivity(i);
    }

    public void mylocation(View view) {
        //Uri u=Uri.parse("geo:16.178600, 81.132492?z=20");
        //Uri u=Uri.parse("geo:16.178600, 81.132492?q=restaurants");
        //Uri u=Uri.parse("geo:16.178600, 81.132492?q=<16.178600>,<81.132492>");
        Uri u=Uri.parse("geo:0, 0?q=restaurants");
        Intent i=new Intent(Intent.ACTION_VIEW,u);

        startActivity(i);
    }

    public void send(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, et.getText().toString());
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);

    }

    public void camera(View view) {

    }
}