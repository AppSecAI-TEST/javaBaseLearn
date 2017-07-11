package com.test;

import com.learn.service.GzipCompressor;
import org.junit.Test;

import javax.annotation.Resource;

import static java.lang.System.out;

/**
 * Created by xia_yu on 2017/7/11.
 */
public class GzipTest {
    @Resource
    GzipCompressor gzipCompressor;

    @Test
    public void compressor() throws Exception {
        String data="测试gzip压缩过程";
        byte[] result=gzipCompressor.stringCompress(data);
        out.println(result);
    }
}
