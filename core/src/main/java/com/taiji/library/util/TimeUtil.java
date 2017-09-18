package com.taiji.library.util;

import com.blankj.utilcode.utils.TimeUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：panho on 2017-4-17 13:32
 * 邮箱: panhongzhi02@163.com
 * 功能描述：
 */

public class TimeUtil {

    public static String TimeFormat(String time, SimpleDateFormat dateFormat){
       Date date = TimeUtils.string2Date(time);
       return TimeUtils.date2String(date,dateFormat);
    }

}
