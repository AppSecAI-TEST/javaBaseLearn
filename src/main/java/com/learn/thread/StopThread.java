package com.learn.thread;

import lombok.Data;

/**
 * Created by xia_yu on 2017/5/29.
 */
@Data
public class StopThread implements Runnable {
    private boolean flag=true;
    public synchronized void run() {
        while (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("子线程"+Thread.currentThread().getName()+"出现异常！");
                flag=false;
            }
            System.out.println("子线程"+Thread.currentThread().getName()+"运行中。。。。。。");
        }
    }
}

class TestStopThread{
    public static void main(String[] args){
        StopThread stopThread=new StopThread();
        Thread t1=new Thread(stopThread);
        Thread t2=new Thread(stopThread);
        t1.start();
        t2.start();
        int num=0;
        while (true){
            if(num++ >= 60){
                t1.interrupt();
                t2.interrupt();
                stopThread.setFlag(false);
                break;
            }
            System.out.println("主线程"+Thread.currentThread().getName()+"运行中。。。。。。");
        }
        System.out.println("主线程执行结束");
    }
}
