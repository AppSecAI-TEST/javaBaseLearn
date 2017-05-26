package com.test;

import com.learn.generic.GenericUpperLimit;
import org.junit.Test;

/**
 * Created by xia_yu on 2017/4/18.
 */
public class GenericUpperLimitTest {
    GenericUpperLimit a=new GenericUpperLimit(100);
    @Test
    public void getData(){
        System.out.println(a.getData());
    }
}
