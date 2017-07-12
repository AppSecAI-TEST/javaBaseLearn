package com.test;

import com.learn.utils.StringUtils;
import org.junit.Test;

/**
 * Created by xia_yu on 2017/5/29.
 */
public class StringTrimTest {
    @Test
    public void trim(){
        System.out.println(StringUtils.trim("  |验证去除前后空格|   "));
    }
    @Test
    public void subStr(){
        String a="验证字符串截取功能";
       /* a= org.apache.commons.lang3.StringUtils.abbreviate(a,8);
        System.out.println(a);*/
        a=a.substring(0,5);
        System.out.println(a);
    }
}
