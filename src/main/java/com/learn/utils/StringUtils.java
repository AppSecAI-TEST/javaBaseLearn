package com.learn.utils;


import com.google.common.collect.Lists;
import com.learn.pojo.Flight;

import java.util.List;

/**
 * Created by xia_yu on 2017/5/29.
 */
public class StringUtils {
    public static final int OUT_BOUND_ID=1;
    public static final int IN_BOUND_ID=2;
    public static String trim(String str){
        int start=0,end=str.length()-1;
        while ((start <= end) && str.charAt(start) == ' '){
            start++;
        }
        while (start<=end && str.charAt(end)==' '){
            end--;
        }
        return str.substring(start,end+1);
    }
    public static String join(){

        return null;
    }

    public static List<List<Flight>> packageFlightSegmentGroup(List<Flight> segmentList) {//对低价接口入参数中的航段分组
        List<List<Flight>> groupList = Lists.newArrayList();
        List<Flight> outBoundSegment = Lists.newArrayList();
        List<Flight> inBoundSegment = Lists.newArrayList();
        for (Flight Flight : segmentList) {
            Integer seqID = Flight.getOrigDestSeqID();
            if (seqID.equals(OUT_BOUND_ID)) {
                outBoundSegment.add(Flight);
            }
            if (seqID.equals(IN_BOUND_ID)) {
                inBoundSegment.add(Flight);
            }
        }
        if (outBoundSegment.size() > 0) {
            groupList.add(outBoundSegment);
        }
        if (inBoundSegment.size() > 0) {
            groupList.add(inBoundSegment);
        }
        return groupList;
    }
    public static String getSegmentsRouting(List<Flight> segmentList) {//取退改签信息

        List<List<Flight>> flightGroup=packageFlightSegmentGroup(segmentList);
        if(flightGroup.size()==0){
            return "";
        }
        StringBuilder outBoundRouting=new StringBuilder();//去程退改签信息
        StringBuilder inBoundRouting=new StringBuilder();//回程退改签信息
        StringBuilder returnRouting=new StringBuilder();
        List<Flight> outBoundFlightList=flightGroup.get(0);//去程航段
        int outBoundFlightSize=outBoundFlightList.size();
        if(outBoundFlightSize==1){
            Flight outBoundFlight=outBoundFlightList.get(0);
            outBoundRouting.append(outBoundFlight.getDepCity()+"-").append(outBoundFlight.getMarketingCarrier()+"-").append(outBoundFlight.getArrCity());
        }else{
            for(int i=0;i<outBoundFlightSize;i++){
                Flight outBoundFlight=outBoundFlightList.get(i);
                if(i==(outBoundFlightSize-1)){
                    outBoundRouting.append(outBoundFlight.getArrCity());
                }else{
                    outBoundRouting.append(outBoundFlight.getDepCity()+"-").append(outBoundFlight.getMarketingCarrier()+"-");
                }
            }
        }

        if(flightGroup.size()==2){//有回程信息
            List<Flight> inBoundFlightList=flightGroup.get(1);//回程航段
            int inBoundFlightSize=inBoundFlightList.size();
            if(inBoundFlightSize==1){
                Flight inBoundFlight=inBoundFlightList.get(0);
                outBoundRouting.append(inBoundFlight.getDepCity()+"-").append(inBoundFlight.getMarketingCarrier()+"-").append(inBoundFlight.getArrCity());
            }else{
                for(int j=0;j<inBoundFlightSize;j++){
                    Flight inBoundFlight=inBoundFlightList.get(j);
                    if(j==(inBoundFlightSize-1)){
                        inBoundRouting.append(inBoundFlight.getArrCity());
                    }else{
                        inBoundRouting.append(inBoundFlight.getDepCity()+"-").append(inBoundFlight.getMarketingCarrier()+"-");
                    }
                }
            }
        }
        if(!outBoundRouting.toString().equals("")){
            returnRouting.append(outBoundRouting);
        }
        if(!inBoundRouting.toString().equals("")){
            returnRouting.append("|").append(inBoundRouting);
        }
        return returnRouting.toString();
    }
}
