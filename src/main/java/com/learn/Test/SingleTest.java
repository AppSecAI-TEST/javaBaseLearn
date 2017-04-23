package com.learn.Test;

import com.learn.design.single.Single;
import org.junit.Test;

/**
 * Created by xia_yu on 2017/4/23.
 */
public class SingleTest {
    @Test
    public void single(){
        Single single=Single.getInstance();
        single.setNum(100);
    }
}
