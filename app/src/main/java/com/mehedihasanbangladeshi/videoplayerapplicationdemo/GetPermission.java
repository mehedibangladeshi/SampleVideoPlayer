package com.mehedihasanbangladeshi.videoplayerapplicationdemo;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class GetPermission {

    static final int READ_STORAGE_PERMISSION_CODE = 1234;

    private Activity activity;


    public GetPermission(Activity activity) {
        this.activity = activity;
    }

    public void checkPermissions(){


        if(ContextCompat
                .checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){

            Toast.makeText(activity, "Already granted", Toast.LENGTH_SHORT).show();

        }else {
            requestForPermission();
        }
    }

    private void requestForPermission() {
        if (ActivityCompat
                .shouldShowRequestPermissionRationale(activity,
                        Manifest.permission.READ_EXTERNAL_STORAGE)){

            new AlertDialog.Builder(activity)
                    .setTitle("Permission Needed")
                    .setMessage("Give permission for this to continue")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(activity,
                                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                    READ_STORAGE_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();



        }else {
            ActivityCompat.requestPermissions(activity,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    READ_STORAGE_PERMISSION_CODE);
        }

    }

}
