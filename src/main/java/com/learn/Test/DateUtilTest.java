package com.learn.Test;

import com.learn.utils.DateUtil;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
        Date result=DateUtil.getDateFromNow(5,DATE_PATTERN);
        System.out.println(result);
    }
    @Test
    public void setGregorianCalendarTest(){
        GregorianCalendar gregorianCalendar=new GregorianCalendar();
        gregorianCalendar.setTime(new Date());
        XMLGregorianCalendar gc=null;
        try {
            gc= DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        System.out.println(gc.toGregorianCalendar().getTime());
    }

}
