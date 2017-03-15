package collection.learn;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xia_yu on 2017/3/15.
 */
public class SetCollection {
    public static void main(String[] x){
        Set set=new HashSet();
        set.add("李");
        set.add("王");
        set.add("明");
        System.out.println(set);
        Set sortSet=new TreeSet(set);
        System.out.println(sortSet);
    }
}
