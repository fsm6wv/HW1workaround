package edu.virginia.sde.hw1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;




public class DataReading {
    public static int[] indexFinder(String path) {
        int stateIndex = -1;
        int popIndex = -1;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String[] components = br.readLine().split(",");
            for (int i = 0; i <components.length; i++){
                if (components[i].strip().toLowerCase().equals("state")){
                    stateIndex = i;
                }
                else if (components[i].strip().toLowerCase().equals("population")){
                    popIndex = i;
                }
            }
            if(stateIndex==-1){
                System.out.println("State column not found - can not continue");
                System.exit(0);
            }
            else if(popIndex == -1){
                System.out.println("Population column not found - can not continue");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Invalid filename - file not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Unable to read file - IOException");
            e.printStackTrace();
            System.exit(0);
        }
        int[] arr = {stateIndex,popIndex};
        return arr;
    }
    public static ArrayList<String> csvFileReader(String path) {
        ArrayList<String> DataList = new ArrayList<>();
        //used geeksforgeeks "Reading a text file into a Java Hashmap" https://www.geeksforgeeks.org/reading-text-file-into-java-hashmap/
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line1 = br.readLine(); //first line is titles
            String line;
            while ((line = br.readLine()) != null) {
                DataList.add(line);
            }
            //check to see if data was read into arraylist
            if(DataList.size() <= 0){
                System.out.println("File is empty - no data was found, end the program");
                System.exit(0);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid filename - file not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Unable to read file - IOException");
            e.printStackTrace();
            System.exit(0);
        }
        return DataList;
    }
    public static ArrayList<String> sortedStateListMaker(ArrayList<String> list, HashMap<String,Integer> map,int stateIndex){
        ArrayList<String> statelist = new ArrayList<>();
        for(String line: list) {
            String[] components = line.split(",");
            var state = components[stateIndex].strip();
            if (map.get(state) != null && map.get(state) >0)
                statelist.add(state);
        }
        Collections.sort(statelist);
        return statelist;
    }

    public static HashMap<String, Integer> unsortedListToHashMap(ArrayList<String> list, int stateIndex, int popIndex){
        HashMap<String,Integer> datamap = new HashMap<>();
        int lineNumber=0;
        for(String line: list){
            String[] components = line.split(",");
            try {
                if(stateIndex<components.length && popIndex<components.length && components.length>1){
                    var state = components[stateIndex].strip();
                    var population = Integer.parseInt(components[popIndex].strip());
                    if (population > 0) {
                        datamap.put(state, population);
                    }
                }
            }
            catch(NumberFormatException e){
                System.out.println("Line "+lineNumber+": Bad input: "+components[1].strip());
                //System.exit(0);
            }
            lineNumber++;
        }
        if (datamap.isEmpty()){
            System.out.println("No valid data entries were found - apportionment aborted.");
            System.exit(0);
        }
        return datamap;
    }
    public static int checkNumReps(String[] list){
        int Representatives = 435;
        if (list.length>=2) try{
            int numReps = Integer.parseInt(list[1].strip());
            if(numReps<=0) {
                System.out.println("Invalid User Input - Number of representatives must be positive and nonzero");
                System.exit(0);
            }
            Representatives = numReps;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid User Input - Number of representatives must be an integer");
            System.exit(0);
        }
        return Representatives;
    }


  }




