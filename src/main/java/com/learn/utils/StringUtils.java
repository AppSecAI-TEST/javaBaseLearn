package com.learn.utils;

/**
 * Created by xia_yu on 2017/5/29.
 */
public class StringUtils {
    public static String trim(String str){
        int start=0,end=str.length()-1;
        while ((start <= end) && str.charAt(start) == ' '){
            start++;
        }
        while (start<=end && str.charAt(end)==' '){
            end--;
        }
        return str.substring(start,end+1);
    }
}
