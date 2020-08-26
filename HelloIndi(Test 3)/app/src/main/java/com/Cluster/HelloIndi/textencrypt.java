package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import java.security.MessageDigest;
import java.util.*;
import java.util.Base64;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class textencrypt extends AppCompatActivity implements View.OnClickListener {
    EditText et1,et2,et3,et4,p1,p2;
    Button b1,b2,b3,b4,b5;
    int t=0;

    String outputstring;
    String AES ="AES";

    private static final String alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textencrypt);

        et1=findViewById(R.id.editTextTextPersonName2);
        et2=findViewById(R.id.editTextTextPersonName4);
        et3=findViewById(R.id.editTextTextPersonName5);
        et4=findViewById(R.id.editTextTextPersonName6);

        p1=findViewById(R.id.editTextTextPersonName7);
        p2=findViewById(R.id.editTextTextPersonName8);

        b1=findViewById(R.id.button12);
        b2=findViewById(R.id.button13);
        b3=findViewById(R.id.button14);
        b4=findViewById(R.id.button10);
        b5=findViewById(R.id.button11);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button12:
                view.setBackground(getResources().getDrawable(R.drawable.button_border_green_gradent));
                b2.setBackground(getResources().getDrawable(R.drawable.dark_gradent));
                b3.setBackground(getResources().getDrawable(R.drawable.dark_gradent));
                t=1;
                break;
            case R.id.button13:
                view.setBackground(getResources().getDrawable(R.drawable.button_border_green_gradent));
                b1.setBackground(getResources().getDrawable(R.drawable.dark_gradent));
                b3.setBackground(getResources().getDrawable(R.drawable.dark_gradent));
                t=2;
                break;
            case R.id.button14:
                view.setBackground(getResources().getDrawable(R.drawable.button_border_green_gradent));
                b1.setBackground(getResources().getDrawable(R.drawable.dark_gradent));
                b2.setBackground(getResources().getDrawable(R.drawable.dark_gradent));
                t=3;
                break;
            case R.id.button10:
                if(t==1)
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        Base64.Encoder encoder = Base64.getEncoder();
                        et2.setText(encoder.encodeToString(et1.getText().toString().getBytes()));
                    }
                    break;
                }
                else if(t==2)
                {
                    try {
                        outputstring =encrypt(et1.getText().toString(), p1.getText().toString());
                        et2.setText(outputstring);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
                else if(t==3)
                {
                    et2.setText(encode(et1.getText().toString(), Integer.parseInt(p1.getText().toString())));
                    break;
                }
            case R.id.button11:
                if(t==1)
                {
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                        Base64.Decoder decoder = Base64.getDecoder();
                        String dStr = new String(decoder.decode(et3.getText().toString()));
                        et4.setText(dStr);
                    }
                    break;
                }
                else if(t==2)
                {
                    try {
                        outputstring=decrypt(et3.getText().toString(),p2.getText().toString());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    et4.setText(outputstring);
                    break;
                }
                else if(t==3)
                {

                    et4.setText(decode(et3.getText().toString(), Integer.parseInt(p2.getText().toString())));
                    break;
                }
        }
    }

    public String encode(String string,int key)
    {
        String st="";
        for(int i=0;i<string.length();i++)
        {

            int ascii = (int) string.charAt(i);
            if(ascii>=97 && ascii<=122)
            {
                if(key>26)
                {
                    key=key%26;
                }
                ascii+=key;
                if(ascii>122)
                {
                    ascii=ascii-26;
                }
                st+=new Character((char) ascii);
            }
            else
            {

                if(key>26)
                {
                    key=key%26;
                }
                ascii+=key;
                if(ascii>90)
                {
                    ascii=ascii-26;
                }
                st+=new Character((char) ascii);
            }

        }
        return st;
    }


    public String decode(String string,int key)
    {
        String st="";
        for(int i=0;i<string.length();i++)
        {
            int ascii = (int) string.charAt(i);
            if(ascii>=97 && ascii<=122)
            {
                if(key>26)
                {
                    key=key%26;
                }
                ascii-=key;
                if(ascii<97)
                {
                    //97 to 122     123 97
                    ascii=ascii+26;
                }
                st+=new Character((char) ascii);
            }
            else
            {
                if(key>26)
                {
                    key=key%26;
                }
                ascii-=key;
                if(ascii<65)
                {
                    //97 to 122     123 97
                    //65 to 90
                    ascii=ascii+26;
                }
                st+=new Character((char) ascii);
            }

        }
        return st;
    }

    private String decrypt(String outputstring, String password) throws Exception {
        SecretKeySpec key= generateKey(password);
        Cipher c= Cipher.getInstance(AES);
        c.init(Cipher.DECRYPT_MODE, key);

        byte[] decodedValue =android.util.Base64.decode(outputstring,android.util.Base64.DEFAULT);
        byte[] decValue =c.doFinal(decodedValue);
        String decryptedValue =new String(decValue);
        return decryptedValue;
    }
    private String encrypt(String Data, String password) throws Exception {
        SecretKeySpec key= generateKey(password);
        Cipher c= Cipher.getInstance(AES);
        c.init(Cipher.ENCRYPT_MODE,key);
        byte[] encVal =c.doFinal(Data.getBytes());
        String encryptedValue= android.util.Base64.encodeToString(encVal,android.util.Base64.DEFAULT);
        return encryptedValue ;

    }

    private SecretKeySpec generateKey(String password) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes= password.getBytes("UTF-8");
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec =new SecretKeySpec(key,"AES");
        return secretKeySpec;

    }

    public void copytext(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text",et2.getText().toString());
        clipboard.setPrimaryClip(clip);
    }
}


//    AES encryption

