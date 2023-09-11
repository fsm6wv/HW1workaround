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
        //int Representatives = checkNumReps(args);
        int Representatives = 4;
        System.out.println("Number of Representatives: " + Representatives);
        String file = args[0];
        ArrayList<String> dataList = ListMaker(file);
        ArrayList<String> sortedList = sortedStateListMaker(dataList);
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


//        try(FileReader filereader = new FileReader(file); CSVReader csvReader = new CSVReader(filereader)) {
//            String [] fileline;
//            //Resource Used: https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv
//            //Description: Used to read file line by line till end of file
//            csvReader.readNext();
//            while((fileline=csvReader.readNext())!=null){
//                String key = fileline[0].trim();
//                String value = fileline[1].trim();
//                datamap.put(key,Integer.parseInt(value));
//                States.add(key);
//                //Add here a way to split the lines into name and population, validate pop. value, store both
//            }
//
//        }
//        catch(NumberFormatException e){
//            System.out.println("Invalid population: must be an integer value");
//            System.exit(0);
//        }
//        catch(IOException e ){
//            System.out.println("Unable to read file - IOException");
//            System.exit(0);
//        }catch(CsvValidationException ee){
//            System.out.println("Unable to read file - CsvValidationException");
//            System.exit(0);
//        }

    }

}



