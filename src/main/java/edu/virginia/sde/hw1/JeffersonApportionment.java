package edu.virginia.sde.hw1;

import java.util.ArrayList;
import java.util.HashMap;

public class JeffersonApportionment extends DataReading {

    public static int getTotalPopulation(ArrayList<String> list, HashMap<String, Integer> map) {
        int totalpop = 0;
        for (String state : list) {
            if (state != null) {
                if (map.get(state) != null) {
                    int x = map.get(state);
                    totalpop = totalpop + x;
                }
            }
        }
        return totalpop;
    }
//    public static int findDivisor(ArrayList<String> statelist, HashMap<String,Integer> datamap, int RealnumOfReps){
//        //check to make sure that RealnumOfReps is a positive/ nonzero number
//        if(RealnumOfReps <= 0){
//            System.out.println("Improper input - Real representative count should be greater than 0" +
//                    ", program ends");
//            System.exit(0);
//        }
//        int totalpop = getTotalPopulation(statelist, datamap);
//        if (RealnumOfReps > totalpop){
//            System.out.println("Improper input - Can not have more Representatives than citizens");
//            System.exit(0);
//        }
//        int divisor = totalpop / RealnumOfReps;
//        int RepCount = 0;
//        while (RepCount != RealnumOfReps) {
//            RepCount = 0;
//            for (String state : statelist) {
//                RepCount += Math.floor(datamap.get(state) / divisor);
//            }
//            if (RepCount != RealnumOfReps) {
//                if (RepCount > RealnumOfReps) {
//                    divisor = divisor + divisor * 10/100;
//                }
//                else{
//                    divisor = divisor- divisor*10/100;
//                }
//            }
//        }
//        return divisor;
//
//    }
     public static HashMap<String, Integer> makeRepNMap(ArrayList<String> statelist, HashMap<String,Integer> datamap, int RealnumOfReps) {
         int divisor = findDivisor(statelist,datamap,RealnumOfReps);
         HashMap<String, Integer> congress= new HashMap<>();
         for (String state: statelist) {
             if (datamap.get(state) != null) {
                 congress.put(state, datamap.get(state) / divisor);
             }
         }
         return congress;
     }


    public static int findDivisor(ArrayList<String> statelist, HashMap<String,Integer> datamap, int RealnumOfReps){
        //check to make sure that RealnumOfReps is a positive/ nonzero number
        if(RealnumOfReps <= 0){
            System.out.println("Improper input - Real representative count should be greater than 0" +
                    ", program ends");
            System.exit(0);
        }
        int totalpop = getTotalPopulation(statelist, datamap);
        if (RealnumOfReps > totalpop){
            System.out.println("Improper input - Can not have more Representatives than citizens");
            System.exit(0);
        }
        int low = 1;
        int divisor = totalpop / RealnumOfReps;
        int high = Integer.MAX_VALUE;
        int RepCount =0;
        while (low<= high){
            RepCount = 0;
            divisor= low + (high-low)/2;
            for (String state : statelist) {
                if( datamap.get(state)!= null){
                    RepCount += Math.floor(datamap.get(state) / divisor);
                }
            }
            if (RepCount == RealnumOfReps){
                return divisor;
            }
            else if(RepCount > RealnumOfReps){
                low = divisor+1;
            }
            else {
                high = divisor-1;

            }
        }
        return divisor;

    }
}