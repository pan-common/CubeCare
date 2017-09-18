package com.taiji.library.data.constant;

import android.Manifest;
import android.os.Build;
import android.support.annotation.RequiresApi;

/**
 * Created by panho on 2016/10/20.
 */

public class PermissionsConstant {

    public static final int REQUEST_CAMERA = 1;
    public static final int REQUEST_EXTERNAL_READ = 2;
    public static final int REQUEST_EXTERNAL_WRITE = 3;
    public static final int REQUEST_LOCATION = 4;
    public static final int REQUEST_RECORD_AUDIO = 5;

    public static final String[] PERMISSIONS_CAMERA = {
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    public static final String[] PERMISSIONS_EXTERNAL_WRITE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public static final String[] PERMISSIONS_EXTERNAL_READ = {
            Manifest.permission.READ_EXTERNAL_STORAGE
    };

    public static final String[] PERMISSIONS_RECORD_AUDIO = {
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    /**
     * 百度地图定位动态申请权限
     */
    public static final String[] PERMISSIONS_LOCATION = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
}
