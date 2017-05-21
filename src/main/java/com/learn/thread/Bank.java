package com.learn.thread;

/**
 * Created by xia_yu on 2017/5/21.
 */
public class Bank {
    private int deposit;
    public synchronized void add(int x) {
            deposit=deposit+x;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("储蓄额为："+deposit);
    }
}
class Customer implements Runnable{
    private Bank bank=new Bank();
    public void run() {
            for(int x=0;x<3;x++){
                bank.add(100);
            }
    }
}

class CustomerTest{
    public static void main(String[] args){
        Customer customer=new Customer();
        Thread t1=new Thread(customer);
        Thread t2=new Thread(customer);
        t1.start();
        t2.start();
    }
}