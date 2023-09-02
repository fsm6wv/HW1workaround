package edu.virginia.sde.hw1;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        try{
            int numReps = Integer.parseInt(args[1]);
            if(numReps<=0) {
                System.out.println("Invalid User Input - Number of representatives must be positive and nonzero");
                System.exit(0);
            }
            }
        catch(NumberFormatException e){
            System.out.println("Invalid User Input - Number of representatives must be an integer");
            System.exit(0);
        }


        System.out.println("Hello World!");
        String file = args[0];
        try {
            FileReader filereader = new FileReader(file);
        }
        catch(Exception e){

        }

    }
}
