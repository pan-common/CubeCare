package com.taiji.library.application;

import android.content.Context;
import android.os.Environment;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.alipay.euler.andfix.patch.PatchManager;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * 描述：应用初始化类
 * 创建人： panho
 * 创建时间： 2016-11-28
 */

public class Application extends MultiDexApplication{

    private PatchManager mPatchManager;

    private static final String APATCH_PATH = "/out.apatch";
    private String version;

    @Override
    public void onCreate() {
        super.onCreate();
        //摄像头扫描二维码
        ZXingLibrary.initDisplayOpinion(this);
        //阿里热更新框架
        try {
            version = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            mPatchManager = new PatchManager(this);
            mPatchManager.init(version);
            mPatchManager.loadPatch();
            String patchFileString = Environment.getExternalStorageDirectory().getAbsolutePath()
                    +APATCH_PATH;
            mPatchManager.addPatch(patchFileString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

}
