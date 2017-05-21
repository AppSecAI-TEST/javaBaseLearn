package com.learn.thread;

/**
 * Created by xia_yu on 2017/5/21.
 */
public class DieLock implements Runnable{
    private boolean flag;
    public DieLock(boolean flag) {
        this.flag = flag;
    }

    public void run() {
        if(flag){
            synchronized (LockUtil.lockA){
                System.out.println("标记为真时的A锁");
                synchronized (LockUtil.lockB){
                    System.out.println("标记为真时的B锁");
                }
            }
        }else{
            synchronized (LockUtil.lockB){
                System.out.println("标记为假时的B锁");
                synchronized (LockUtil.lockA){
                    System.out.println("标记为假时的A锁");
                }
            }
        }
    }
}
class LockUtil{
    static Object lockA=new Object();
    static Object lockB=new Object();
}

class DieLockTest{
    public static void main(String[] args){
        DieLock dieLockA=new DieLock(true);
        DieLock dieLockB=new DieLock(false);
        Thread threadA=new Thread(dieLockA);
        Thread threadB=new Thread(dieLockB);
        threadA.start();
        threadB.start();
    }
}
