package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class TruthOrDare extends AppCompatActivity {
    GridLayout gl1;
    DynamicView dv;
    EditText et1;
    Context context;
    List<EditText> editTexts;
    ArrayList<String> players;
    int init=0,init1=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_or_dare);

        gl1=findViewById(R.id.gl);
        editTexts=new ArrayList<EditText>();
        players=new ArrayList<String>();
    }


    public void add(View view) {
        dv=new DynamicView(context);
        editTexts.add(dv.getPlayers(getApplicationContext(),init));
        gl1.addView(editTexts.get(init));
        init++;
    }

    public void play(View view) {
        for (int j = 0; j < editTexts.size(); j++)
        {
            players.add(editTexts.get(j).getText().toString());
        }
        Intent i=new Intent(this,TruthOrDare_play.class);
        i.putExtra("players", players);
        startActivity(i);
    }


}