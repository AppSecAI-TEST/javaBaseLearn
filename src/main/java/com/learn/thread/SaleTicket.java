package com.learn.thread;

/**
 * Created by xia_yu on 2017/5/21.
 */
public class SaleTicket extends Thread {
    private int count=100;
    @Override
    public void run() {
       while (true){
           if(count>0){
               System.out.println("线程"+this.getName()+"卖出"+(count--)+"号票");
           }
       }
    }
}

class SaleTicketTest{
    public static void main(String[] args){
        Thread t1=new SaleTicket();
        Thread t2=new SaleTicket();
        Thread t3=new SaleTicket();
        Thread t4=new SaleTicket();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
