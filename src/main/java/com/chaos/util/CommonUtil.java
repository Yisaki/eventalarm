package com.chaos.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
}
