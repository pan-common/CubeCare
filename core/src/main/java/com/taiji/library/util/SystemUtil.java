package com.taiji.library.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

import java.util.UUID;

/**
 * 描述：
 * 创建人： panho
 * 创建时间： 2016-12-19
 */

public class SystemUtil {

    /**
     * 获取32位guid的唯一表示
     */
    public static String getGUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getDeviceId(Context context){
        UUID uuid;
        final SharedPreferences preferences = context.getSharedPreferences("device_id.xml",Context.MODE_PRIVATE);
        final String id = preferences.getString("device_id",null);
        if(id!=null){
            uuid = UUID.fromString(id);
        }else {
            final String androidId = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
            try {
                if(!"9774d56d682e549c".equals(androidId)){
                    uuid = UUID.nameUUIDFromBytes(androidId.getBytes("utf-8"));
                }else {
                    final String deviceId = ((TelephonyManager) context.getSystemService( Context.TELEPHONY_SERVICE )).getDeviceId();
                    uuid = deviceId!=null ? UUID.nameUUIDFromBytes(deviceId.getBytes("utf8")) : UUID.randomUUID();
                }
            }catch (Exception e){
                throw new RuntimeException(e);
            }
            preferences.edit().putString("device_id", uuid.toString() ).commit();
        }
        return uuid.toString();
    }

}
