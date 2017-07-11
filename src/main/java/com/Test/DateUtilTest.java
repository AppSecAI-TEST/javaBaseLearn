package com.test;

import com.google.common.collect.*;
import com.learn.utils.DateUtil;
import com.netflix.config.DynamicStringSetProperty;
import org.junit.Test;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.UnsupportedEncodingException;
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
    @Test
    public void testDateUtils() throws UnsupportedEncodingException {
        String str = gbkTransfer("FS/CN/GDS/WD");
        System.out.println(str);
        String str2 = toGBK("FS/CN/GDS/WD");
        System.out.println(str2);
    }

    @Test
    public void testImmutableSet(){
        DynamicStringSetProperty AGENCY_SET = new DynamicStringSetProperty("bestBuy.agencyCodes", "SZX|SZX763,BJS|BJS101,SHA|SHA717,CAN|CAN819,CTU|CTU446,HGXC|HGH106,CKGZ|CKG137");
        ImmutableSet<String> agentAndOfficeNoSet = FluentIterable.from(AGENCY_SET.get()).toSet();
    }

    public static String toGBK(String source) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        byte[] bytes = source.getBytes("GB2312");
        for(byte b : bytes) {
            if(b>127){
                sb.append("%" + Integer.toHexString((b & 0xff)).toUpperCase());
            }else{
                sb.append((char)b);
            }
        }
        return sb.toString();
    }

    private String gbkTransfer(String data) throws UnsupportedEncodingException {
        String result = "";
        boolean isChinese = false;
        int HZ1 = 0;
        int HZ2 = 0;
        int HZ3 = 0;
        int HZ4 = 0;
        int GB1;
        int GB2;
        byte[] bs = data.getBytes("GB2312");
        for (int i = 0; i < bs.length; i++) {
            int t = bs[i];
            if (t > 128) {
                if (!isChinese) {
                    isChinese = true;
                }

                GB1 = t;
                GB2 = bs[++i];

                if (GB1 >= 176 && GB1 <= 247 && GB2 >= 161 && GB2 <= 254) {
                    byte[] b1 = new byte[2];
                    b1[0] = (byte) GB1;
                    b1[1] = (byte) GB2;
                    String w1 = new String(b1, "GB2312");

                    result += w1;
                } else {

                    int i1 = GB1 - 129;
                    int i2 = GB2 - 64;

                    HZ1 = 120;
                    HZ2 = 71 + i1 / 16;

                    HZ3 = 68 + i2 / 64 + (i1 % 16) * 4;
                    if (HZ3 >= 128) {
                        HZ3 -= 64;
                        HZ2 += 1;
                    }
                    HZ4 = 63 + i2 % 64;

                    if (HZ1 <= 36) {
                        HZ1 = HZ1 + 142;
                        HZ2 = HZ2 + 128;
                    } else if (HZ1 >= 51) {
                        HZ1 = HZ1 + 128;
                        HZ2 = HZ2 + 128;
                    } else if (HZ1 >= 37 && HZ1 <= 40) {
                        int ihz1 = HZ2;
                        int ihz2 = HZ1;
                        HZ2 = (char) ((int) ihz2 + 138);
                        if ((int) ihz1 <= 36)
                            HZ1 = (char) ((int) ihz1 + 142);
                        else if ((int) ihz1 >= 51)
                            HZ1 = (char) ((int) ihz1 + 128);
                    }

                    byte[] b1 = new byte[2];
                    b1[0] = (byte) HZ1;
                    b1[1] = (byte) HZ2;
                    String w1 = new String(b1, "GB2312");

                    if (HZ3 <= 36) {
                        HZ3 = HZ3 + 142;
                        HZ4 = HZ4 + 128;
                    } else if (HZ3 >= 51) {
                        HZ3 = HZ3 + 128;
                        HZ4 = HZ4 + 128;
                    } else if (HZ3 >= 37 && HZ3 <= 40) {
                        int ihz1 = HZ4;
                        int ihz2 = HZ3;
                        HZ4 = (char) ((int) ihz2 + 138);
                        if ((int) ihz1 <= 36)
                            HZ3 = (char) ((int) ihz1 + 142);
                        else if ((int) ihz1 >= 51)
                            HZ3 = (char) ((int) ihz1 + 128);
                    }

                    byte[] b2 = new byte[2];
                    b2[0] = (byte) HZ3;
                    b2[1] = (byte) HZ4;
                    String w2 = new String(b2, "GB2312");

                    result += w1 + w2;
                }
            } else {
                result += (char) t;
            }
        }

        return result;
    }

}
