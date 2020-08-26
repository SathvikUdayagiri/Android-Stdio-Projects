package com.Cluster.HelloIndi;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    ImageView iv1;
    TextToSpeech tts;
    Random r;
    String Results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent j=new Intent(this,SplashScreen.class);
        startService(j);

        iv1=findViewById(R.id.imageView8);
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

        Intent i=new Intent(this,ShakeDetectionService.class);
        startService(i);



    }
    public void cluster(View view) {
        Intent i=new Intent(this,Cluster.class);
        startActivity(i);
    }

    public void helloindi(View view) {
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
                    Results=result.get(0);
                    voiceRecogo();
                }
                break;
        }
    }





    public void voiceRecogo()
    {
        //Toss a Coin
        if(Results.equalsIgnoreCase("Toss a Coin"))
        {
            int t=r.nextInt(2);
            if(t==0)
            {
                tts.speak("You got Heads",TextToSpeech.QUEUE_FLUSH,null);
            }
            else
            {
                tts.speak("You got Tails",TextToSpeech.QUEUE_FLUSH,null);
            }
        }
        //Roll a dice
        else if(Results.equalsIgnoreCase("roll a dice"))
        {
            int t=r.nextInt(6);
            if(t==0)
            {
                tts.speak("its 1",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==1)
            {
                tts.speak("its 2",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==2)
            {
                tts.speak("its 3",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==3)
            {
                tts.speak("its 4",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==4)
            {
                tts.speak("its 5",TextToSpeech.QUEUE_FLUSH,null);
            }
            else  if(t==5)
            {
                tts.speak("its 6",TextToSpeech.QUEUE_FLUSH,null);
            }
        }
        //Who is Bobby
        else if(Results.equalsIgnoreCase("Who is Bobby"))
        {
            tts.speak("He is Thota Mohan and he is a developer of this app",TextToSpeech.QUEUE_FLUSH,null);
        }
        //Who is Sathvik
        else if(Results.equalsIgnoreCase("Who is Sathvik") || Results.equalsIgnoreCase("Who is Satvik"))
        {
            tts.speak("he is a developer of this app",TextToSpeech.QUEUE_FLUSH,null);
        }
        //Who is Rahul
        else if(Results.equalsIgnoreCase("Who is Rahul"))
        {
            tts.speak("he is a developer of this app",TextToSpeech.QUEUE_FLUSH,null);
        }
        //Who is Hemanth
        else if(Results.equalsIgnoreCase("Who is Hemanth"))
        {
            tts.speak("he is a developer of this app",TextToSpeech.QUEUE_FLUSH,null);
        }
        //What is Time.
        else if((Results.equalsIgnoreCase("what time is it")) ||
                (Results.equalsIgnoreCase("what is time")) ||
                (Results.equalsIgnoreCase("what is time now")) || (Results.equalsIgnoreCase("time")))
        {
            Time now = new Time();
            now.setToNow();
            tts.speak("its"+now,TextToSpeech.QUEUE_FLUSH,null);
        }
        //How are You
        else if((Results.equalsIgnoreCase("how are you")) || (Results.equalsIgnoreCase("how's are you doing")))
        {
                tts.speak("Thanks for asking, I am good. How are you",TextToSpeech.QUEUE_FLUSH,null);
        }
        //How old are you
        else if((Results.equalsIgnoreCase("how old are you")) || (Results.equalsIgnoreCase("when are you born")))
        {
                tts.speak("I was born on august second 2020,the year of disaster",TextToSpeech.QUEUE_FLUSH,null);
        }
        //Hi
        else if((Results.equalsIgnoreCase("hi")) || (Results.equalsIgnoreCase("hello")) || (Results.equalsIgnoreCase("hey")))
        {
                tts.speak("Hey, how are you doing",TextToSpeech.QUEUE_FLUSH,null);
        }
        //I am bored
        else if((Results.equalsIgnoreCase("I am bored" )) || (Results.equalsIgnoreCase("boring")))
        {
            tts.speak(" you can play games available in this app",TextToSpeech.QUEUE_FLUSH,null);
        }
        //What's up
        else if(Results.equalsIgnoreCase("what's up" ))         {

            tts.speak("have you got anything interesting.",TextToSpeech.QUEUE_FLUSH,null);
        }
        //I Love you
        else if((Results.equalsIgnoreCase("I love you " ))  || (Results.equalsIgnoreCase("do you love me" )))
        {
            tts.speak("I love everyone",TextToSpeech.QUEUE_FLUSH,null);
        }
        //What am I
        else if(Results.equalsIgnoreCase("what am i" ))
        {
            tts.speak("you are a nice human being",TextToSpeech.QUEUE_FLUSH,null);
        }
        //Nice to meet you
        else if((Results.equalsIgnoreCase("nice to meet you" )) || (Results.equalsIgnoreCase("you are nice" )) || (Results.equalsIgnoreCase("you are awesome" )) || (Results.equalsIgnoreCase("I like you"))               || (Results.equalsIgnoreCase("nice talking to you" )))
        {
            tts.speak("you are making me blush. Thank you so much. I like you too",TextToSpeech.QUEUE_FLUSH,null);
        }
        //Tell me a joke
        else if(Results.equalsIgnoreCase("tell me a joke" ))
        {
            int t=r.nextInt(4);
            switch(t)
            {
                    case 0:
                    tts.speak("ice and water hugged hugged each other and became ice water.i know its lame",TextToSpeech.QUEUE_FLUSH,null);

                    case 1:
                    tts.speak("today I got proposal, in my dreams though. Haha",TextToSpeech.QUEUE_FLUSH,null);

                    case 2:
                    tts.speak("hmmm, I don't know many jokes",TextToSpeech.QUEUE_FLUSH,null);

                    case 3:
                    tts.speak("one day, I was on the road. Sorry I forgot ",TextToSpeech.QUEUE_FLUSH,null);

                    case 4:
                        tts.speak("ice and water hugged hugged each other and became ice water.i know its lame",TextToSpeech.QUEUE_FLUSH,null);

                    case 5:
                        tts.speak("today I got proposal, in my dreams though. Haha",TextToSpeech.QUEUE_FLUSH,null);

                    case 6:
                        tts.speak("hmmm, I don't know many jokes",TextToSpeech.QUEUE_FLUSH,null);

                    case 7:
                        tts.speak("one day, I was on the road. Sorry I forgot ",TextToSpeech.QUEUE_FLUSH,null);

                    case 8:
                        tts.speak("The hokey pokey can be tough the first time you try it. But eventually you turn yourself around",TextToSpeech.QUEUE_FLUSH,null);
                    case 9:
                        tts.speak("'Write an essay cricket' the teacher told the class. Banti finishes his work in five minutes. The teaches is impressed, she asks Banti to read his essay aloud for everyone. Banti to read hisessay aloud for everyone. Banti reads 'The cricket match is cancelled beacause of rain'",TextToSpeech.QUEUE_FLUSH,null);

                    case 10:
                        tts.speak("Why can't astronauts eat popsicles? In space. no one can hear the ice cream truck !!!",TextToSpeech.QUEUE_FLUSH,null);

                    case 11:
                        tts.speak("What's the first thing a monster eats after he's had his teeth checked. The dentist !!!",TextToSpeech.QUEUE_FLUSH,null);

                    case 12:
                        tts.speak("Why are cricket stadiums so cool? Beacause every seat has a fan in it.",TextToSpeech.QUEUE_FLUSH,null);

                    case 13:
                        tts.speak("What do you call a rose that wants to go to the moon?  Gulab ja moon!!",TextToSpeech.QUEUE_FLUSH,null);

                    case 14:
                        tts.speak("What is the riches fish in the world? Goldfish",TextToSpeech.QUEUE_FLUSH,null);
            }

        }
    }

}
