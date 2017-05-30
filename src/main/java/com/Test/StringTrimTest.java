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
}
