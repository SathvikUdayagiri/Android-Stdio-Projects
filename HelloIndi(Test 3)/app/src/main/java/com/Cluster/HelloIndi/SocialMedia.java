package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class SocialMedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social_media);
    }

    public void whatsapp(View view) {
        Uri u= Uri.parse("https://web.whatsapp.com/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void telegram(View view) {
        Uri u= Uri.parse("https://web.telegram.org/#/login");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void instagram(View view) {
        Uri u= Uri.parse("https://www.instagram.com/?hl=en");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void twitter(View view) {
        Uri u= Uri.parse("https://twitter.com/login?lang=en");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void facebook(View view) {
        Uri u= Uri.parse("https://www.facebook.com/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }

    public void pinterest(View view) {
        Uri u= Uri.parse("https://pinterest.com/");
        Intent i=new Intent(Intent.ACTION_VIEW,u);
        startActivity(i);
    }
}