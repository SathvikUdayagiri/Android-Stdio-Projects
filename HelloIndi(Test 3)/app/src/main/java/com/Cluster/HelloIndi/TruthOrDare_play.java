package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class TruthOrDare_play extends AppCompatActivity {
    List<String> players;
    ImageView iv1;
    TextView tv1;
    Random r;
    int cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_or_dare_play);

        Bundle extras = getIntent().getExtras();
        players=extras.getStringArrayList("players");
        iv1=findViewById(R.id.imageView15);
        tv1=findViewById(R.id.textView5);
        r=new Random();
    }


    public void spin(View view) {
        RotateAnimation rotateAnimation=new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);
        iv1.startAnimation(rotateAnimation);
        cs=r.nextInt(players.size());
        tv1.setText(players.get(cs));
    }

    public void selfspin(View view) {
        int i=r.nextInt(360);
        RotateAnimation rotateAnimation1=new RotateAnimation(0,i,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation1.setDuration(1000);
        rotateAnimation1.setFillAfter(true);
        iv1.startAnimation(rotateAnimation1);
    }
}