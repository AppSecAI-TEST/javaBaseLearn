package com.learn.Test;

import com.learn.utils.JsonUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by xia_yu on 2017/5/11.
 */
public class FormatUtilTest {
    @Test
    public void JsonFormatUtil() throws UnsupportedEncodingException, FileNotFoundException {
        String result= JsonUtil.readJsonFile("src//main//file//source.json","UTF-8");
        String formatRes=JsonUtil.formatJson(result);
        System.out.println(formatRes);
    }
}
