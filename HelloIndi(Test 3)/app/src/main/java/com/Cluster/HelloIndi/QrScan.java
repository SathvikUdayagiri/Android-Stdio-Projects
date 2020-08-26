package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import org.json.JSONException;
import org.json.JSONObject;

public class QrScan extends AppCompatActivity {
    private TextView tv1;
    private IntentIntegrator qrScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_scan);

        tv1=findViewById(R.id.textView6);
        qrScan = new IntentIntegrator(this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null)
        {
            if (result.getContents() == null)
            {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            }
            else
            {
                try
                {
                    JSONObject obj = new JSONObject(result.getContents());
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                    tv1.setText(result.getContents());
                    Toast.makeText(this, ((IntentResult) result).getContents(), Toast.LENGTH_LONG).show();
                }
            }
        }
        else
        {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    public void scan(View view) {
        qrScan.initiateScan();
    }

    public void copytext(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("Copied Text",tv1.getText().toString());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this, "Text is Scanned", Toast.LENGTH_SHORT).show();
    }
}