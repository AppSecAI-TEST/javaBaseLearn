package com.learn.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xia_yu on 2017/5/29.
 */
public class ThreadLock {
    private String name;
    private int count=1;
    private boolean flag=false;
    private Lock lock=new ReentrantLock();
    private Condition conditionProducer=lock.newCondition();
    private Condition conditionConsumer=lock.newCondition();
    public void produceGoods(String name){
        lock.lock();
        try {
            while(flag)
                    conditionProducer.await();
                this.name=name+"=="+(count++);
                System.out.println(Thread.currentThread().getName()+"===生产者生产==="+this.name);
                flag=true;
                conditionConsumer.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void consumerGoods(){
        lock.lock();
        try{
            while (!flag)
                    conditionConsumer.await();
                System.out.println(Thread.currentThread().getName()+"======消费者消费======"+this.name);
                flag=false;
                conditionProducer.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class ProducerThread implements Runnable{
    private ThreadLock threadLock;

    public ProducerThread(ThreadLock threadLock) {
        this.threadLock = threadLock;
    }
    public void run() {
        while(true){
            threadLock.produceGoods("商品");
        }
    }
}
class ConsumerThread implements Runnable{
    private ThreadLock threadLock;

    public ConsumerThread(ThreadLock threadLock) {
        this.threadLock = threadLock;
    }

    public void run() {
        while(true){
            threadLock.consumerGoods();
        }
    }
}
class TestThreadLock{
    public static void main(String[] args){
        ThreadLock threadLock=new ThreadLock();
        ProducerThread producerThread=new ProducerThread(threadLock);
        ConsumerThread consumerThread=new ConsumerThread(threadLock);
        Thread producer1=new Thread(producerThread);
        Thread producer2=new Thread(producerThread);
        Thread consumer1=new Thread(consumerThread);
        Thread consumer2=new Thread(consumerThread);
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}

