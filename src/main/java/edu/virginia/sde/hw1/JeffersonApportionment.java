package edu.virginia.sde.hw1;
import java.util.ArrayList;
import java.util.HashMap;

public class JeffersonApportionment extends DataReading {

    public static int getTotalPopulation(ArrayList<String> list, HashMap<String, Integer> map) {
        int totalPop = 0;
        for (String state : list) {
            if (state != null) {
                if (map.get(state) != null) {
                    int x = map.get(state);
                    totalPop = totalPop + x;
                }
            }
        }
        return totalPop;
    }

     public static HashMap<String, Integer> makeRepNMap(ArrayList<String> statelist, HashMap<String,Integer> datamap, int RealnumOfReps) {
         double divisor = findDivisor(statelist,datamap,RealnumOfReps);
         HashMap<String, Integer> congress= new HashMap<>();
         for (String state: statelist) {
             if (datamap.get(state) != null) {
                 double newRepCount =datamap.get(state) / divisor;
                 int castedRepCount = (int) newRepCount;
                 congress.put(state, castedRepCount);
             }
         }
         return congress;
     }
        public static double findDivisor(ArrayList<String> statelist, HashMap<String,Integer> datamap, int realNumOfReps){
        //check to make sure that realNumOfReps is a positive/ nonzero number
        if(realNumOfReps <= 0){
            System.out.println("Improper input - representative count should be greater than 0" +
                    ", program ends");
            System.exit(0);
        }
        int totalpop = getTotalPopulation(statelist, datamap);
        if (realNumOfReps > totalpop){
            System.out.println("Improper input - Can not have more Representatives than citizens");
            System.exit(0);
        }
        double divisor = totalpop / realNumOfReps;
        int repCount = 0;
        while (repCount != realNumOfReps) {
            repCount = 0;
            for (String state : statelist) {
                if(datamap.get(state) != null && datamap.get(state)>0)
                    repCount += Math.floor(datamap.get(state) / divisor);
            }
            if (repCount != realNumOfReps) {
                if (repCount > realNumOfReps) {
                    divisor += divisor *.1;
                }
                else{
                    divisor -= divisor*.1;
                }
            }
        }
        return divisor;

    }
}