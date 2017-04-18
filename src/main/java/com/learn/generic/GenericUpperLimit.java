package com.learn.generic;

import lombok.Data;

/**
 * Created by xia_yu on 2017/4/18.
 */
@Data
public class GenericUpperLimit<T extends Number> {
    private T data;
    public GenericUpperLimit(){

    }
    public GenericUpperLimit(T data){
        this.data=data;
    }
}
