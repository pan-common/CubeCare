package com.taiji.library.util;

import com.google.gson.Gson;

import java.util.UUID;

/**
 * Created by panho on 2016/11/3.
 */

public class MyUtil {

    /**
     * 获取32位guid的唯一表示
     */
    public static String getGUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 将对象转json字符串
     * @param object
     * @return
     */
    public static String toJson(Object object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        return json;
    }

}
