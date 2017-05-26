package com.test;

import com.learn.thread.Ticket;

/**
 * Created by xia_yu on 2017/5/21.
 */
public class TicketTest {
    public static void main(String[] args){
        Ticket ticket=new Ticket();
        Thread t1=new Thread(ticket);
        Thread t2=new Thread(ticket);
        Thread t3=new Thread(ticket);
        Thread t4=new Thread(ticket);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
