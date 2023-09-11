package edu.virginia.sde.hw1;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Main extends JeffersonApportionment{
    public static void main(String[] args) {
        //Resource Used: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/lang/Integer.html
        //Description: used Integer class to parse user input
        //check to make sure that csv path is entered as a command line argument
        if(args.length < 1){
            throw new ArrayIndexOutOfBoundsException("CSV file path is missing - should be entered" +
                    " through as a command line argument");
        }

        int Representatives = checkNumReps(args);
        System.out.println("Number of Representatives: " + Representatives);
        String file = args[0];
        ArrayList<String> dataList = ListMaker(file);
        HashMap<String, Integer> initialMap = ListToHashMap(dataList);
        ArrayList<String> sortedList = sortedStateListMaker(dataList,initialMap);
        //for (String x : dataList) System.out.println(x);
        HashMap<String,Integer> dataMap = ListToHashMap(dataList);
        //int totalpop = getTotalPopulation(dataList,dataMap);
        HashMap<String,Integer> finalRepMap = makeRepNMap(sortedList,dataMap,Representatives);
        for (String key: sortedList) {
            {
                if (finalRepMap.get(key) != null)
                    System.out.println("State: " + key + "           Number of Representatives: " + finalRepMap.get(key));
            }
        }
        System.out.println("Total Number of Representatives: " + Representatives);


        //Resource Used: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        //Description: learning about try-with-resources
    }

}



