package com.taiji.library.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import com.taiji.library.data.constant.PermissionsConstant;

import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.RECORD_AUDIO;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

/**
 * Created by panho on 2016/10/20.
 */

public class PermissionUtil {
    /**
     * SD卡读取权限
     * @param activity
     * @return
     */
    public static boolean checkReadStoragePermission(Activity activity) {
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            return true;
        }
        int readStoragePermissionState =
                ContextCompat.checkSelfPermission(activity, READ_EXTERNAL_STORAGE);

        boolean readStoragePermissionGranted = readStoragePermissionState == PackageManager.PERMISSION_GRANTED;

        if (!readStoragePermissionGranted) {
            ActivityCompat.requestPermissions(activity,
                    PermissionsConstant.PERMISSIONS_EXTERNAL_READ,
                    PermissionsConstant.REQUEST_EXTERNAL_READ);
        }
        return readStoragePermissionGranted;
    }

    /**
     * SD卡写入权限
     * @param activity
     * @return
     */
    public static boolean checkWriteStoragePermission(Activity activity) {

        int writeStoragePermissionState =
                ContextCompat.checkSelfPermission(activity, WRITE_EXTERNAL_STORAGE);

        boolean writeStoragePermissionGranted = writeStoragePermissionState == PackageManager.PERMISSION_GRANTED;

        if (!writeStoragePermissionGranted) {
            ActivityCompat.requestPermissions(activity,PermissionsConstant.PERMISSIONS_EXTERNAL_WRITE,
                    PermissionsConstant.REQUEST_EXTERNAL_WRITE);
        }
        return writeStoragePermissionGranted;
    }

    public static boolean checkCameraPermission(Activity activity) {
        int cameraPermissionState = ContextCompat.checkSelfPermission(activity, CAMERA);

        boolean cameraPermissionGranted = cameraPermissionState == PackageManager.PERMISSION_GRANTED;

        if (!cameraPermissionGranted) {
            ActivityCompat.requestPermissions(activity,PermissionsConstant.PERMISSIONS_CAMERA,
                    PermissionsConstant.REQUEST_CAMERA);
        }
        return cameraPermissionGranted;
    }

    public static boolean checkLocationPermission(Activity activity) {
        int locationPermissionState = ContextCompat.checkSelfPermission(activity,ACCESS_COARSE_LOCATION);

        boolean locationPermissionGranted = locationPermissionState == PackageManager.PERMISSION_GRANTED;
        if(!locationPermissionGranted){
            ActivityCompat.requestPermissions(activity,PermissionsConstant.PERMISSIONS_LOCATION
                    ,PermissionsConstant.REQUEST_LOCATION);
        }
        return locationPermissionGranted;
    }

    public static boolean checkRecordAudioPermission(Activity activity){
        int recordAudioPermission = ContextCompat.checkSelfPermission(activity,RECORD_AUDIO);
        boolean recordAudioPermissionGranted = recordAudioPermission == PackageManager.PERMISSION_GRANTED;
        if(recordAudioPermissionGranted){
            ActivityCompat.requestPermissions(activity,PermissionsConstant.PERMISSIONS_RECORD_AUDIO,PermissionsConstant.REQUEST_RECORD_AUDIO);
        }
        return  recordAudioPermissionGranted;
    }

}
