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

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {// used chatgpt with format: "write a java function that reads a csv and stores it into a hashmap". Changed a bit of it to fit the assignment better
            br.readLine();
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
//    }




