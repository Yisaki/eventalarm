package com.chaos.util;

import java.io.UnsupportedEncodingException;
import java.lang.Math;
import java.net.URLEncoder;
import java.util.Date;

public class CommonUtil {

    public static  String urlEncodeWithUtf8(String src){
        String result=null;
        try {
            result= URLEncoder.encode(src,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param begin 开始日期
     * @param end 结束日期
     * @return
     */
    public static int getSubDay(Date begin,Date end){
        long gapTime = end.getTime() - begin.getTime();
        int gapDay = Math.round(gapTime / 1000 / 60 / 60 / 24);
        return gapDay;
    }

}
