package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Voice extends AppCompatActivity {
    EditText et;
    Vibrator v;
    float pitch,speed;
    TextToSpeech tts;
    SeekBar sb1,sb2;
    ImageView iv1;
    Random r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voice);

        et=findViewById(R.id.editTextTextPersonName);
        sb1=findViewById(R.id.seekBar);
        sb2=findViewById(R.id.seekBar2);
        iv1=findViewById(R.id.imageView2);
        r=new Random();
        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                {
                    int result=tts.setLanguage(Locale.getDefault());
                    if(result==TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED)
                    {
                        Log.e("TTS","Language not supported");
                    }
                    else
                    {
                        iv1.setEnabled(true);
                    }
                }
                else
                {
                    Log.e("TTS","Initialization failed");
                }
            }
        });
    }


    public void voice(View view) {
        Intent i=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        startActivityForResult(i,1);
        if (i.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(i, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    et.setText(result.get(0));
                    voiceRecogo();
                }
                break;
        }
    }

    public void play(View view) {
        String text=et.getText().toString();
        if(text.isEmpty())
        {
            text="Please enter any text";
        }
        pitch=(float) sb1.getProgress()/50;
        if(pitch<0.1) pitch=0.1f;
        speed=(float) sb2.getProgress()/50;
        if(speed<0.1) speed=0.1f;
        tts.setPitch(pitch);
        tts.setSpeechRate(speed);
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        voiceRecogo();
    }

    @Override
    protected void onDestroy() {
        if(tts!=null)
        {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    public void voiceRecogo()
    {
        if(et.getText().toString().equalsIgnoreCase("Toss a Coin"))
        {
            int t=r.nextInt(2);
            if(t==0)
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("You got Heads",TextToSpeech.QUEUE_FLUSH,null);
            }
            else
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("You got Tails",TextToSpeech.QUEUE_FLUSH,null);
            }
        }

        else if(et.getText().toString().equalsIgnoreCase("roll a dice"))
        {
            int t=r.nextInt(6);
            if(t==0)
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("its 1",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==1)
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("its 2",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==2)
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("its 3",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==3)
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("its 4",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==4)
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("its 5",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==5)
            {
                speed=(float) sb2.getProgress()/50;
                pitch=(float) sb1.getProgress()/50;
                tts.setPitch(pitch);
                tts.setSpeechRate(speed);
                tts.speak("its 6",TextToSpeech.QUEUE_FLUSH,null);
            }
        }
    }
}