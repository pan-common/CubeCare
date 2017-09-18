package com.taiji.library.util;

import android.util.Base64;

import com.blankj.utilcode.utils.EncodeUtils;
import com.blankj.utilcode.utils.ScreenUtils;

import java.security.MessageDigest;

/**
 * Created by panho on 2016-11-8.
 */

public class MD5Util {

    private static final char[] HEX = {'0','1','2','3','4','5','6','7','8','9',
            'a','b','c','d','e','f'};

    private static char[] encode(byte[] bytes){
        final int nBytes = bytes.length;
        char[] result = new char[2*nBytes];
        int j = 0;
        for (int i = 0; i < nBytes; i++) {
            // Char for top 4 bits
            result[j++] = HEX[(0xF0 & bytes[i]) >>> 4];
            // Bottom 4
            result[j++] = HEX[(0x0F & bytes[i])];
        }
        return result;
    }


    /**
     * MD5加密
     * @param password
     * @return
     */
    public static String MD5Encoder(String password){
        String encrupt = "";
        try {
            byte[] bytes = password.getBytes("utf-8");
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] digestBytes = digest.digest(bytes);
            encrupt = new String(encode(digestBytes));
            encrupt = new String(EncodeUtils.base64Encode(encrupt));
        }catch (Exception e){
            e.printStackTrace();
        }
        return encrupt;
    }

}
