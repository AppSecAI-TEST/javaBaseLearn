package com.learn.generic;

import lombok.Data;

/**
 * Created by xia_yu on 2017/4/18.
 */
@Data
public class Generic<T> {
    private T data;
    public Generic(){

    }
    public Generic(T data){
        this.data=data;
    }
}
