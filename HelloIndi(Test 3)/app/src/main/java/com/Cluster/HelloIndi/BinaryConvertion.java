package com.Cluster.HelloIndi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class BinaryConvertion extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    int b,o,d,h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_convertion);
        et1=findViewById(R.id.editTextNumber);
        et2=findViewById(R.id.editTextNumber2);
        et3=findViewById(R.id.editTextNumber3);
        et4=findViewById(R.id.editTextNumber4);
    }

    public void convert(View view) {
        if(TextUtils.isEmpty(et1.getText().toString()) && TextUtils.isEmpty(et2.getText().toString()) && TextUtils.isEmpty(et3.getText().toString()) && TextUtils.isEmpty(et4.getText().toString())) {
            Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(et2.getText().toString()) && TextUtils.isEmpty(et3.getText().toString()) && TextUtils.isEmpty(et4.getText().toString()))
        {
            boolean check=isBinary(Integer.parseInt(et1.getText().toString()));
            if(check)
            {
                b=Integer.parseInt(et1.getText().toString(), 2);
                et2.setText(Integer.toOctalString(b));
                et3.setText(Integer.toString(b));
                et4.setText(Integer.toHexString(b));
            }
            else
            {
                Toast.makeText(this, "Please enter a binary number", Toast.LENGTH_SHORT).show();
            }
        }
        else if(TextUtils.isEmpty(et1.getText().toString()) && TextUtils.isEmpty(et3.getText().toString()) && TextUtils.isEmpty(et4.getText().toString()))
        {
            boolean check=isOctal(et2.getText().toString());
            if(check)
            {
                o=Integer.parseInt(et2.getText().toString(), 8);
                et1.setText(Integer.toBinaryString(o));
                et3.setText(Integer.toString(o));
                et4.setText(Integer.toHexString(o));
            }
            else
            {
                Toast.makeText(this, "Please enter a Octal number", Toast.LENGTH_SHORT).show();
            }
        }
        else if(TextUtils.isEmpty(et1.getText().toString()) && TextUtils.isEmpty(et2.getText().toString()) && TextUtils.isEmpty(et4.getText().toString()))
        {
            boolean check=isNumeric(et3.getText().toString());
            if(check)
            {
                d=Integer.parseInt(et3.getText().toString());
                et1.setText(Integer.toBinaryString(d));
                et2.setText(Integer.toOctalString(d));
                et4.setText(Integer.toHexString(d));
            }
            else
            {
                Toast.makeText(this, "Please enter a decimal number", Toast.LENGTH_SHORT).show();
            }
        }
        else if(TextUtils.isEmpty(et1.getText().toString()) && TextUtils.isEmpty(et2.getText().toString()) && TextUtils.isEmpty(et3.getText().toString()))
        {
            boolean check=isHex(et4.getText().toString());
            if(check)
            {
                h= Integer.parseInt(et4.getText().toString(), 16);
                et1.setText(Integer.toBinaryString(h));
                et2.setText(Integer.toOctalString(h));
                et3.setText(Integer.toString(h));
            }
            else
            {
                Toast.makeText(this, "Please enter a Hexadecimal number", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Clear to enter again", Toast.LENGTH_SHORT).show();
        }
    }

    public void clear(View view) {
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");
    }

    public static boolean isBinary(int number) {
        int copyOfInput = number;

        while (copyOfInput != 0) {
            if (copyOfInput % 10 > 1) {
                return false;
            }
            copyOfInput = copyOfInput / 10;
        }
        return true;
    }

    public static boolean isOctal(String octal) {

        boolean isOctal = false;

        if (octal != null && !octal.isEmpty()) {
            int number = Integer.parseInt(octal);

            while (number > 0) {
                if (number % 10 <= 7) {
                    isOctal = true;
                } else {
                    isOctal = false;
                    break;
                }
                number /= 10;
            }
        }
        return isOctal;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isHex(String value) {
        boolean ret;
        try {
            int t = Integer.parseInt(value, 16);
            ret = true;
        } catch (NumberFormatException e) {
            ret = false;
        }
        return (ret);
    }

}