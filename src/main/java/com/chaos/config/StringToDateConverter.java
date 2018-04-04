package com.chaos.config;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringToDateConverter implements Converter<String, Date> {
    private static final String dateFormat    = "yyyy-MM-dd HH:mm:ss";
    @Override
    public Date convert(String s) {
        Date date=null;
        SimpleDateFormat sdf=new SimpleDateFormat(dateFormat);
        try {
            date=sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
