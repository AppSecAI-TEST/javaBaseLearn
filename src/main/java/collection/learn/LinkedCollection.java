package collection.learn;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Created by xia_yu on 2017/3/15.
 */
public class LinkedCollection {
    public static void main(String[] x){
        Collection linked=new LinkedList();
        linked.add("周");
        linked.add("吴");
        linked.add("郑");
        linked.add("王");
        System.out.println(linked);
    }
}
