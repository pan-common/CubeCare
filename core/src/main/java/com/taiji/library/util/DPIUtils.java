package com.taiji.library.util;

import android.app.Activity;
import android.util.DisplayMetrics;

/**
 * 作者：panho on 2017-3-1 10:22
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class DPIUtils {

    public static final int HDPI=0;
    public static final int MDPI=1;
    public static final int LDPI=2;
    public static final int HHDPI=3;
    public static final int I_DO_NOT_KNOW=4;

    private Activity activity;
    /** 屏幕宽度（像素）*/
    private int width;
    /**屏幕高度（像素）*/
    private int height;
    /**屏幕密度（0.75 / 1.0 / 1.5）*/
    private float density;
    /**屏幕密度DPI（120 / 160 / 240 /320）*/
    private static int densityDpi;

    /**
     * 构造方法，初始化并获取屏幕的一些信息
     * @param activity
     */
    public DPIUtils(Activity activity){
        this.activity = activity;
        ini();
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getDensity() {
        return density;
    }

    public void setDensity(float density) {
        this.density = density;
    }

    public int getDensityDpi() {
        return densityDpi;
    }

    public void setDensityDpi(int densityDpi) {
        DPIUtils.densityDpi = densityDpi;
    }

    private void ini(){
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);
        width = metric.widthPixels;
        height = metric.heightPixels;
        density = metric.density;
        densityDpi = metric.densityDpi;
    }

    /**
     * 判断手机屏幕分辨率高低
     */
    public int getScreenDPI(){
        if(densityDpi==120){
            return LDPI;
        }else if(densityDpi==160){
            return MDPI;
        }else if(densityDpi==240){
            return HDPI;
        }else if(densityDpi==320){
            return HHDPI;
        }else{
            return I_DO_NOT_KNOW;
        }
    }

}
