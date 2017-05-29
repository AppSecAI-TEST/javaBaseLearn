package com.learn.thread;

import lombok.Data;

/**
 * Created by xia_yu on 2017/5/29.
 */
@Data
public class Goods {
    private String name;
    private int count=1;
    private boolean flag=false;
    public synchronized void produceGoods(String name){
        while(flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.setName(name+(count++));
        System.out.println(Thread.currentThread().getName()+"===生产者生产==="+this.getName());
        this.setFlag(true);
        this.notifyAll();
    }
    public synchronized void consumerGoods(){
        while(!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+"======消费者消费======"+this.getName());
        this.setFlag(false);
        this.notifyAll();
    }
}

class Producer implements Runnable{
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    public void run() {
        while (true){
            goods.produceGoods("商品");
        }
    }
}

class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    public void run() {
        while (true){
            goods.consumerGoods();
        }
    }
}

class TestGoods{
    public static void main(String[] args){
        Goods goods=new Goods();
        Producer producer=new Producer(goods);
        Consumer consumer=new Consumer(goods);
        Thread producer1=new Thread(producer);
        Thread producer2=new Thread(producer);
        Thread consumer1=new Thread(consumer);
        Thread consumer2=new Thread(consumer);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}