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
            throw new ArrayIndexOutOfBoundsException("File path is missing - should be entered" +
                    " through as a command line argument");
        }

        int representatives = 435;//checkNumReps(args);
        String file = args[0];
        int[] indexArr;
        if(DataReading.isCSV(args[0])){
            indexArr = CSVIndexFinder(file);
        }
        else{
            indexArr = excelIndexFinder(file);
        }
        int popIndex = indexArr[1];
        int stateIndex = indexArr[0];
        ArrayList<String> dataList = readFile(file);
        HashMap<String, Integer> initialMap = unsortedListToHashMap(dataList,stateIndex,popIndex);
        ArrayList<String> sortedList = sortedStateListMaker(dataList,initialMap,stateIndex);
        HashMap<String,Integer> finalRepMap = makeRepNMap(sortedList,initialMap,representatives);
        System.out.println("State           |Population|Reps ");
        for (String key: sortedList) {
            if (finalRepMap.get(key) != null){
            String formatState = String.format("%-16s",key);
            String pop = Integer.toString(initialMap.get(key));
            String formattedPop = String.format("%10s", pop);
            String stateRepNum = Integer.toString(finalRepMap.get(key));
            String formattedStateRepNum = String.format("%5s",stateRepNum);
            System.out.println(formatState +"|" + formattedPop+"|"+formattedStateRepNum);
            }
        }
        System.out.println("Total Number of representatives: " + representatives);


        //Resource Used: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        //Description: learning about try-with-resources
    }

}



