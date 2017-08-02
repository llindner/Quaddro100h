package br.com.luizlindner.quaddro100h.lab10.app.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

/**
 * Created by Mobile on 01/08/2017.
 */

public final class PermissionHelper {

    private PermissionHelper(){
        super();
    }

    public static boolean checkPermissions(Activity context, String permission, int requestCode){
        int result = ActivityCompat.checkSelfPermission(context, permission);
        if(result == PackageManager.PERMISSION_GRANTED){
            return true;
        } else {
            if(ActivityCompat.shouldShowRequestPermissionRationale(context, permission)){
                Toast.makeText(context, "Favor habilitar permissão", Toast.LENGTH_SHORT);
            }

            ActivityCompat.requestPermissions(context, new String[]{permission}, requestCode);
        }
        return false;
    }

}
