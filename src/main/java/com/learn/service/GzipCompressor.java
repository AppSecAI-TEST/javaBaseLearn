package com.learn.service;

/**
 * Created by xia_yu on 2017/7/11.
 */
public interface GzipCompressor {
    /**
     * gzip压缩
     * @param data
     * @return
     * @throws Exception
     */
    byte[] compress(byte[] data) throws Exception;

    /**
     * gzip解压
     * @param data
     * @return
     * @throws Exception
     */
    byte[] deCompress(byte[] data) throws Exception;

    /**
     * 压缩字符串
     * @param data
     * @return
     * @throws Exception
     */
    byte[] stringCompress(String data) throws Exception;
}
