package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TossGame extends AppCompatActivity {
    Button b1;
    ImageView iv1;
    TextView tv1;
    Random r;
    int cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toss_game);

        b1=findViewById(R.id.button2);
        iv1=findViewById(R.id.imageView6);
        tv1=findViewById(R.id.textView3);
        r=new Random();
    }

    public void Toss(View view) {
        cs=r.nextInt(2);
        if(cs==0)
        {
            iv1.setImageResource(R.drawable.heads);
            tv1.setText("Heads");
            Toast.makeText(this, "Heads", Toast.LENGTH_SHORT).show();
        }
        else
        {
            iv1.setImageResource(R.drawable.coin);
            tv1.setText("Tails");
            Toast.makeText(this, "Tails", Toast.LENGTH_SHORT).show();
        }
        RotateAnimation rotateAnimation=new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);
        iv1.startAnimation(rotateAnimation);
    }
}