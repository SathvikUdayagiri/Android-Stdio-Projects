package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QrGenerate extends AppCompatActivity {
    ImageView iv1;
    EditText et1,et2,et3,et4,et5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_generate);

        iv1=findViewById(R.id.imageView16);

        et1=findViewById(R.id.editTextTextPersonName3);
        et2=findViewById(R.id.editTextTextEmailAddress2);
        et3=findViewById(R.id.editTextPhone2);
        et4=findViewById(R.id.editTextTextPostalAddress3);
        et5=findViewById(R.id.editTextTextMultiLine2);
    }


    public void generate(View view) {
        int width = 512;
        int height = 512;
        String text="Name: "+et1.getText().toString()+
                "\n"+"Email Id: "+et2.getText().toString()+
                "\n"+"Phone No: "+et3.getText().toString()+
                "\n"+"Postal Address: "+et4.getText().toString()+
                "\n"+"Some Text: "+et5.getText().toString();
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,512,512);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    if (bitMatrix.get(x, y)==false)
                        bitmap.setPixel(x, y, Color.rgb(255,255,255));
                    else
                        bitmap.setPixel(x, y, Color.rgb(0,0,0));
                }
            }
            iv1.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}