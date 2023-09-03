package edu.virginia.sde.hw1;
import java.io.*;
import java.lang.*;
import java.util.Arrays;

import com.opencsv.CSVReader;
public class Main {
    public static void main(String[] args) {
        int Representatives = 435;
        //Resource Used: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/lang/Integer.html
        //Description: used Integer class to parse/check user input (line 11)
        try{
            int numReps = Integer.parseInt(args[1]);
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
        catch(IndexOutOfBoundsException n){
            //do nothing
            //no 2nd arg, default 435
        }
        System.out.println(Representatives);
        String file = args[0];
        //Resource Used: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html
        //Description: learning about try-with-resources (line 30)
        try(FileReader filereader = new FileReader(file); CSVReader csvReader = new CSVReader(filereader)) {
            String [] fileline;
            //Resource Used: https://www.geeksforgeeks.org/reading-csv-file-java-using-opencsv
            //Description: Used to read file line by line till end of file
            while((fileline=csvReader.readNext())!=null){
                System.out.println(Arrays.toString(fileline));
            }
        }
        catch(Exception e){
            System.out.println("Unable to read file");
            System.exit(0);
        }

    }
}
