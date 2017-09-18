package com.taiji.library.andfix;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * 描述：AndFix补丁
 * 创建人： panho
 * 创建时间： 2016-12-21
 */

public class AndFix {
    //添加补丁
    public static void addPatch(Context context, String patch_path){
        try {
            String version = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            PatchManager patchManager = new PatchManager(context);
            patchManager.loadPatch();
            patchManager.addPatch(patch_path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
