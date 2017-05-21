package com.learn.thread;

/**
 * Created by xia_yu on 2017/5/21.
 */
public class Deposit implements Runnable {
    private int count=1000;
    boolean flag=true;
    public void run() {
        if (flag){
            while (true){
                synchronized (this){
                    if(count>0){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程："+Thread.currentThread().getName()+"消费："+(count--)+"元");
                    }
                }
            }
        }else{
            store();
        }
    }
    public synchronized void store(){
        while (true){
            if(count>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程："+Thread.currentThread().getName()+"消费："+(count--)+"元");
            }
        }
    }
}

class DepositTest{
    public static void main(String[] args){
        Deposit deposit=new Deposit();
        Thread t1=new Thread(deposit);
        Thread t2=new Thread(deposit);
        t1.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        deposit.flag=false;
        t2.start();
    }
}
