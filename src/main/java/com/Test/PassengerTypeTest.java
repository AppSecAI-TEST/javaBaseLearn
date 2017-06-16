package com.test;

import com.learn.enumerate.PassengerType;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by xia_yu on 2017/4/21.
 */
public class PassengerTypeTest {
    @Test
    public void getPassengerTypeCode(){
        int code= PassengerType.Adult.getValue();
        System.out.println(code);
        BigDecimal testbig=new BigDecimal("1.55");
        testbig=testbig.setScale(0,BigDecimal.ROUND_DOWN);
        System.out.println(testbig.toString());
    }
}
