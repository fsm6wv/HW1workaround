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
    public static int findDivisor(ArrayList<String> statelist, HashMap<String,Integer> datamap, int RealnumOfReps){
        int totalpop = getTotalPopulation(statelist, datamap);
        int divisor = totalpop / RealnumOfReps;
        int RepCount = 0;
        while (RepCount != RealnumOfReps) {
            RepCount = 0;
            for (String state : statelist) {
                RepCount += Math.floor(datamap.get(state) / divisor);
            }
            if (RepCount != RealnumOfReps) {
                if (RepCount > RealnumOfReps) {
                    divisor = divisor * 11/10;
                }
                else{
                    divisor = divisor*9/10;
                }
            }
        }
        return divisor;
    }
     public static HashMap<String, Integer> makeRepNMap(ArrayList<String> statelist, HashMap<String,Integer> datamap, int RealnumOfReps) {
         int divisor = findDivisor(statelist,datamap,RealnumOfReps);
         HashMap<String, Integer> congress= new HashMap<>();
         for (String state: statelist){
             congress.put(state, datamap.get(state) / divisor);
         }
         return congress;
     }


}
