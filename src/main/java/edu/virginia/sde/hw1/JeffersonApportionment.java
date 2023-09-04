package edu.virginia.sde.hw1;

import java.util.ArrayList;
import java.util.HashMap;

public class JeffersonApportionment extends DataReading{

    public static int getTotalPopulation(ArrayList<String> list, HashMap<String,Integer> map){
        int totalpop =0;
        for( String state: list ){
            int x = map.get(state);
            totalpop = totalpop+x;
        }
        return totalpop;
    }


}
