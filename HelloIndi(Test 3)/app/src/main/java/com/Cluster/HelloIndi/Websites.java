package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Websites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_websites);
    }
//    Uri u= Uri.parse("");
//    Intent i=new Intent(Intent.ACTION_VIEW,u);
//    startActivity(i);

    public void MyActivity(View view) {
        Uri u= Uri.parse("https://myactivity.google.com/myactivity?pli=1");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void radiogarden(View view) {
        Uri u= Uri.parse("http://radio.garden/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void virustotla(View view) {
        Uri u= Uri.parse("https://www.virustotal.com/gui/home/upload");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void beebom(View view) {
        Uri u= Uri.parse("https://beebom.com/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void naasongs(View view) {
        Uri u= Uri.parse("https://naasongs.co/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void brightside(View view) {
        Uri u= Uri.parse("https://brightside.me/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);

    }

    public void mobilebrands(View view) {
        Uri u= Uri.parse("https://www.bgr.in/gadgets/mobile-phones/brands/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void pediaa(View view) {
        Uri u= Uri.parse("https://pediaa.com/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void logomaker(View view) {
        Uri u= Uri.parse("https://logomaker.thehoth.com/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void softwares(View view) {
        Uri u= Uri.parse("https://www.maketecheasier.com/best-101-free-computer-software-for-your-daily-use/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);

    }

    public void socialmedia(View view) {
        Intent i=new Intent(this,SocialMedia.class);
        startActivity(i);
    }

    public void rapidtables(View view) {
        Uri u= Uri.parse("https://www.rapidtables.com/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}