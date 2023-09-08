package edu.virginia.sde.hw1;
import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Main extends JeffersonApportionment{
    public static void main(String[] args) {
        //Resource Used: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/lang/Integer.html
        //Description: used Integer class to parse user input
        int Representatives = checkNumReps(args);
        System.out.println(Representatives);
        // should file start at args[1] because of the header row?
        String file = args[0];
        ArrayList<String> dataList = ListMaker(file);
        for (String x : dataList) System.out.println(x);

        HashMap<String,Integer> dataMap = ListToHashMap(dataList);
        int totalpop = getTotalPopulation(dataList,dataMap);
        //Resource Used: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        //Description: learning about try-with-resources (line 30)


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



