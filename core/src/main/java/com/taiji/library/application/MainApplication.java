package com.taiji.library.application;

import android.app.Application;
import android.os.Environment;

import com.alipay.euler.andfix.patch.PatchManager;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application{

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
}
