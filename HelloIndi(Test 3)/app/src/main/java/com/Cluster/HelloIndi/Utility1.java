package com.Cluster.HelloIndi;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;

public class Utility1 {
    Context context;
    boolean isSwitchedOn=false;
    public  Utility1(Context context){
        this.context=context;
    }
    public boolean torchToggel(String command) throws CameraAccessException
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M)
        {
            CameraManager cameraManager=(CameraManager)context.getSystemService(Context.CAMERA_SERVICE);
            String Camera_Id=null;
            if(cameraManager!=null)
            {
                Camera_Id=cameraManager.getCameraIdList()[0];
            }
            if(cameraManager!=null)
            {
                if(command.equals("on"))
                {
                    cameraManager.setTorchMode(Camera_Id,true);
                    isSwitchedOn=true;
                }
                else
                {
                    cameraManager.setTorchMode(Camera_Id,false);
                    isSwitchedOn=false;
                }
            }
        }
        return isSwitchedOn;
    }
}
