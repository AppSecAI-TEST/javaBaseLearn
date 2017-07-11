package com.learn.service.impl;

import com.learn.service.GzipCompressor;
import org.apache.commons.io.Charsets;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by xia_yu on 2017/7/11.
 */
@Component("gzipCompressor")
public class GzipCompressorImpl implements GzipCompressor {

    public byte[] compress(byte[] data) throws Exception {
        try( ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();GZIPOutputStream gzipOutputStream=new GZIPOutputStream(byteArrayOutputStream)){
            gzipOutputStream.write(data);
            gzipOutputStream.finish();
            return byteArrayOutputStream.toByteArray();
        }
    }

    public byte[] deCompress(byte[] data) throws Exception {
        try(ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(data.length); GZIPInputStream gzipInputStream=new GZIPInputStream(new ByteArrayInputStream(data))){
            byte[] buffer=new byte[data.length];
            for(; ;){
                int byteRead=gzipInputStream.read(buffer,0,buffer.length);
                if(byteRead<0){
                    break;
                }
                byteArrayOutputStream.write(buffer,0,byteRead);
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    @Override
    public byte[] stringCompress(String data) throws Exception {
        return compress(data.getBytes(Charsets.UTF_8));
    }
}
