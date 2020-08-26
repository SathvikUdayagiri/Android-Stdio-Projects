package com.Cluster.HelloIndi;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraAccessException;
import android.os.IBinder;
import android.os.Vibrator;

import androidx.annotation.Nullable;

public class ShakeDetectionService extends Service implements SensorEventListener {
    int MIN_TIME_BETWEEN_SHAKE=1000;
    SensorManager sensorManager=null;
    Vibrator vibrator;
    long LAST_SHAKE_TIME=0;
    Boolean isFlashLightOn=false;
    Float SHAKE_THRESHOLD=40.0f;
    Utility1 utility;

    public ShakeDetectionService(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        utility=new Utility1(this);
        vibrator=(Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null)
        {
            Sensor accelerometer=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_ACCELEROMETER)
        {
            long curTime=System.currentTimeMillis();
            if((curTime-LAST_SHAKE_TIME)>MIN_TIME_BETWEEN_SHAKE)
            {
                float x=event.values[0];
                float y=event.values[1];
                float z=event.values[2];

                double acceleration=Math.sqrt(Math.pow(x,2)+Math.pow(y,2)+Math.pow(z,2)-SensorManager.GRAVITY_EARTH);
                if(acceleration>SHAKE_THRESHOLD)
                {
                    LAST_SHAKE_TIME=curTime;
                    if(!isFlashLightOn)
                    {
                        try {
                            isFlashLightOn=utility.torchToggel("on");
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    else
                    {
                        try {
                            isFlashLightOn=utility.torchToggel("off");
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
