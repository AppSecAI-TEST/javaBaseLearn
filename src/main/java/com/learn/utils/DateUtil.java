package com.learn.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xia_yu on 2017/4/20.
 */
public class DateUtil {
    public static String getNow(){
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String result=dateFormat.format(date);
        return result;
    }
    public static String getDateFromNow(int num,String pattern){
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,num);
        SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
        String result=dateFormat.format(calendar.getTime());
        return result;
    }
}
