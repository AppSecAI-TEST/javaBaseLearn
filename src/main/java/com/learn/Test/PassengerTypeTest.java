package com.learn.Test;

import com.learn.enumerate.PassengerType;
import org.junit.Test;

/**
 * Created by xia_yu on 2017/4/21.
 */
public class PassengerTypeTest {
    @Test
    public void getPassengerTypeCode(){
        int code= PassengerType.Adult.getValue();
        System.out.println(code);
    }
}
