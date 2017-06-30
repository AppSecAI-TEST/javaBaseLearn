package com.test;

import com.learn.design.single.Single;
import com.learn.pojo.Flight;
import com.learn.utils.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xia_yu on 2017/4/23.
 */
public class SingleTest {
    @Test
    public void single(){
        Single single=Single.getInstance();
        single.setNum(100);
    }
    @Test
    public void routing(){
        List<Flight> FlightList=new ArrayList<Flight>();
        Flight F1=new Flight();
        F1.setMarketingCarrier("CA");
        F1.setDepCity("SHA");
        F1.setArrCity("HKG");
        F1.setOrigDestSeqID(1);
        Flight F2=new Flight();
        F2.setMarketingCarrier("CZ");
        F2.setDepCity("HKG");
        F2.setArrCity("BJS");
        F2.setOrigDestSeqID(1);
        /*Flight F3=new Flight();
        F3.setMarketingCarrier("MU");
        F3.setDepCity("BJS");
        F3.setArrCity("TYO");
        F3.setOrigDestSeqID(1);*/

        Flight IN1=new Flight();
        IN1.setMarketingCarrier("CA");
        IN1.setDepCity("MHU");
        IN1.setArrCity("WHU");
        IN1.setOrigDestSeqID(2);
        Flight IN2=new Flight();
        IN2.setMarketingCarrier("MU");
        IN2.setDepCity("WHU");
        IN2.setArrCity("BJS");
        IN2.setOrigDestSeqID(2);
        Flight IN3=new Flight();
        IN3.setMarketingCarrier("MZ");
        IN3.setDepCity("BJS");
        IN3.setArrCity("HKG");
        IN3.setOrigDestSeqID(2);
        FlightList.add(F1);
        FlightList.add(F2);
        /*FlightList.add(F3);*/
        FlightList.add(IN1);
        FlightList.add(IN2);
        FlightList.add(IN3);
        String result= StringUtils.getSegmentsRouting(FlightList);
        System.out.println(result);
    }
}
