package edu.virginia.sde.hw1;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        int Representatives = 435;
        //Resource Used: https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/lang/Integer.html
        //Description: used Integer class to parse/check user input
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
        //String file = args[0];
        //try {
        //    FileReader filereader = new FileReader(file);
        //}
        //catch(Exception e){

        //}

    }
}



