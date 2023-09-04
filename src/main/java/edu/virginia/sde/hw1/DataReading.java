package edu.virginia.sde.hw1;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;




public class DataReading {
    public static ArrayList<String> ListMaker(String path) {
        ArrayList<String> DataList = new ArrayList<>();
        //used geeksforgeeks "Reading a text file into a Java Hashmap" https://www.geeksforgeeks.org/reading-text-file-into-java-hashmap/
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine(); //first line is titles
            String line;
            while ((line = br.readLine()) != null) {
                DataList.add(line);
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

    public static HashMap<String, Integer> ListToHashMap(ArrayList<String> list){
        HashMap<String,Integer> datamap = new HashMap<>();
        for(String line: list){
            String[] components = line.split(",");
            if (components.length <=2){
                var state = components[0];
                var population = Integer.parseInt(components[1]);
                if (population > 0){
                    datamap.put(state,population);
                }
            }
        }
        return datamap;
    }
    public static int numOfReps(String num, int length){
        int Representatives;
        //Resource Used: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/lang/Integer.html
        //Description: used Integer class to parse/check user input (line 53)
        if (length==2) {
            Representatives = Integer.parseInt(num);
        }
        else{
            Representatives=435;
        }
        return Representatives;
    }


//    public static HashMap<String, Integer> HashMapMaker(String path){
//        HashMap<String,Integer> datamap = new HashMap<>();
//
//        try (BufferedReader br = new BufferedReader(new FileReader(path))) {// used chatgpt with format: "write a java function that reads a csv and stores it into a hashmap". Changed a bit of it to fit the assignment better
//            br.readLine();
//            String line = br.readLine();
//            while(line != null){
//                var list = line.split(",");
//                if(list.length >=2){
//
//                }
//            }
//
//        }
//        catch (FileNotFoundException e){
//            System.out.println("Invalid filename - file not found");
//            System.exit(0);
//        }
//        catch(IOException e ) {
//            System.out.println("Unable to read file - IOException");
//            System.exit(0);
//
//        }
  }




