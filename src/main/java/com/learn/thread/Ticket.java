package com.learn.thread;


/**
 * Created by xia_yu on 2017/5/21.
 */
public class Ticket implements Runnable{
    private int ticketCount=100;
    public void run() {
        while (true){
            synchronized (this){
                if(ticketCount>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程："+Thread.currentThread().getName()+"卖出："+(ticketCount--)+"号票");
                }
            }

        }
    }
}

