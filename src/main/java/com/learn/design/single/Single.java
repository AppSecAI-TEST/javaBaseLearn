package com.learn.design.single;

/**
 * Created by xia_yu on 2017/4/23.
 */
public class Single {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private Single() {
    }
    private static Single single=new Single();
    public static Single getInstance(){
        return single;
    }
}
