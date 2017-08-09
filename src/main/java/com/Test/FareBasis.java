package com.test;

import com.learn.pojo.FareType;
import com.learn.pojo.ParamType;
import org.junit.Test;

import java.util.*;

/**
 * Created by xia_yu on 2017/8/9.
 */
public class FareBasis {
    @Test
    public void filter() {
        List<FareType> fareTypeList = new ArrayList<>();
        FareType fareType1 = new FareType();

        fareType1.setSegmentNo(1);
        fareType1.setDepartCity("BJS");
        fareType1.setFareBasis("ZBS");
        fareTypeList.add(fareType1);

        FareType fareType2 = new FareType();
        fareType2.setSegmentNo(2);
        fareType2.setDepartCity("SHA");
        fareType2.setFareBasis("WBS");
        fareTypeList.add(fareType2);

        FareType fareType3 = new FareType();
        fareType3.setSegmentNo(3);
        fareType3.setDepartCity("WHU");
        fareType3.setFareBasis("WBS");
        fareTypeList.add(fareType3);

        FareType fareType4 = new FareType();
        fareType4.setSegmentNo(4);
        fareType4.setDepartCity("HKG");
        fareType4.setFareBasis("ZHB");
        fareTypeList.add(fareType4);

        List<FareType> cloneFareTypeList=new ArrayList<>();
        cloneFareTypeList.addAll(fareTypeList);
        List<ParamType> paramTypeList=new ArrayList<>();
        for (int i = 0; i < cloneFareTypeList.size() - 1;) {
            FareType curFare = cloneFareTypeList.get(i);//当前fareType
            FareType nextFare = cloneFareTypeList.get(i+1);//相邻的下一个fareType
            if (curFare.getFareBasis().equals(nextFare.getFareBasis())) {//两个fareBasis相同
                nextFare.setSegments(curFare.getSegments() + 1);
                cloneFareTypeList.remove(i);
            } else {
                i++;
            }
        }
        for (int j = 0; j < cloneFareTypeList.size();j++) {
            FareType fareType = cloneFareTypeList.get(j);
            ParamType paramType=new ParamType();
            paramType.setSegmentNo(fareType.getSegmentNo());
            paramType.setFareBasis(fareType.getFareBasis());
            paramType.setSegments(fareType.getSegments());
            paramTypeList.add(paramType);
        }

        System.out.println("原始集合"+fareTypeList);
        System.out.println("复制集合"+cloneFareTypeList);
        System.out.println("结果集合"+paramTypeList);
    }
}
