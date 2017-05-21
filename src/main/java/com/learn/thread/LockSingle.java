package com.learn.thread;

/**
 * Created by xia_yu on 2017/5/21.
 */
public class LockSingle {
    private static LockSingle lockSingle=null;
    private LockSingle(){}
    public static LockSingle getInstance(){
        if(lockSingle==null){
            synchronized (LockSingle.class){
                if(lockSingle==null){
                    lockSingle=new LockSingle();
                }
            }
        }
        return lockSingle;
    }
}
