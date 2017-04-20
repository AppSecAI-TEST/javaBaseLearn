package com.learn.Test;

import com.learn.utils.DateUtil;
import org.junit.Test;

/**
 * Created by xia_yu on 2017/4/20.
 */
public class DateUtilTest {
    private static final String DATE_PATTERN="yyyy-MM-dd";
    @Test
    public void getNowDate(){
        String now= DateUtil.getNow();
        System.out.println(now);
    }
    @Test
    public void getDateFromNow(){
        String result=DateUtil.getDateFromNow(5,DATE_PATTERN);
        System.out.println(result);
    }
}
