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

public class Dice extends AppCompatActivity {
    Button b1;
    ImageView iv1;
    TextView tv1;
    Random r;
    int cs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice);

        b1=findViewById(R.id.button3);
        iv1=findViewById(R.id.imageView14);
        tv1=findViewById(R.id.textView4);
        r=new Random();
    }


    public void roll(View view) {
        cs=r.nextInt(6);
        if(cs==0)
        {
            iv1.setImageResource(R.drawable.dice_1);
            tv1.setText("You Got:1");
            Toast.makeText(this, "You Got 1", Toast.LENGTH_SHORT).show();
        }
        else if(cs==1)
        {
            iv1.setImageResource(R.drawable.dice_2);
            tv1.setText("You Got:2");
            Toast.makeText(this, "You Got 2", Toast.LENGTH_SHORT).show();
        }
        else if(cs==2)
        {
            iv1.setImageResource(R.drawable.dice_3);
            tv1.setText("You Got:3");
            Toast.makeText(this, "You Got 3", Toast.LENGTH_SHORT).show();
        }
        else if(cs==3)
        {
            iv1.setImageResource(R.drawable.dice_4);
            tv1.setText("You Got:4");
            Toast.makeText(this, "You Got 4", Toast.LENGTH_SHORT).show();
        }
        else if(cs==4)
        {
            iv1.setImageResource(R.drawable.dice_5);
            tv1.setText("You Got:5");
            Toast.makeText(this, "You Got 5", Toast.LENGTH_SHORT).show();
        }
        else if(cs==5)
        {
            iv1.setImageResource(R.drawable.dice_6);
            tv1.setText("You Got:6");
            Toast.makeText(this, "You Got 6", Toast.LENGTH_SHORT).show();
        }
        RotateAnimation rotateAnimation=new RotateAnimation(0,360,
                RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(1000);
        iv1.startAnimation(rotateAnimation);
    }
}