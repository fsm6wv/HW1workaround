package edu.virginia.sde.hw1;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.FileInputStream;
import java.util.Iterator;


public class DataReading {


    public static boolean isExcel(String file) {
        String possibleXLSX = file.substring(file.length() - 4);
        return possibleXLSX.equals("xlsx");
    }

    public static boolean isCSV(String file) {
        String possibleCSV = file.substring(file.length() - 3);
        return possibleCSV.equals(("csv"));
    }

    public static String getCellStringValue(Cell currentCell) {
        String value = null;
        if (currentCell != null) {
            switch (currentCell.getCellType()) {
                case STRING:
                    value = currentCell.getStringCellValue();
                    break;
                case NUMERIC:
                    // Convert numeric value to a string
                    double v1 = currentCell.getNumericCellValue();
                    int v2 = (int) v1;
                    value = Integer.toString(v2);
            }
        }
        return value;
    }

    public static ArrayList<String> excelReader(String file) {
        // asked chatGPT how to read an Excel file using java
        ArrayList<String> dataList = new ArrayList<>();
        try {
            FileInputStream excelFile = new FileInputStream(file);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            if (iterator.hasNext()) {
                iterator.next(); // Skip the header
            }
            while(iterator.hasNext()){
                Row currentRow = iterator.next();
                StringBuilder rowAsString = new StringBuilder();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {
                    Cell currentCell = cellIterator.next();
                    rowAsString.append(getCellStringValue(currentCell)).append(",");
                }
                dataList.add(rowAsString.toString());
                if (rowAsString.length() > 0) {
                    rowAsString.deleteCharAt(rowAsString.length() - 1);
                }
                workbook.close();
                excelFile.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid filename - file not found");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Unable to read file - IOException");
            e.printStackTrace();
            System.exit(0);
        }
        return dataList;
    }
    public static ArrayList<String> csvFileReader(String path) {
        ArrayList<String> dataList = new ArrayList<>();
        //used geeksforgeeks "Reading a text file into a Java Hashmap" https://www.geeksforgeeks.org/reading-text-file-into-java-hashmap/
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                dataList.add(line);
            }
            //check to see if data was read into arraylist
            if(dataList.size() <= 0){
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
        return dataList;
    }
    public static ArrayList<String> readFile(String file){
        if(isCSV(file)){
            return csvFileReader(file);
        }
        else if(isExcel(file)){
            return excelReader(file);
        }
        System.out.println("File type invalid, can not continue");
        System.exit(0);
        return null;
    }
    public static int[] excelIndexFinder(String path) {
        int stateIndex = -1;
        int popIndex = -1;
        try {
            FileInputStream excelFile = new FileInputStream(path);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            Row currentRow = iterator.next();
            StringBuilder rowAsString = new StringBuilder();
            Iterator<Cell> cellIterator = currentRow.iterator();
            while (cellIterator.hasNext()) {
                Cell currentCell = cellIterator.next();
                rowAsString.append(currentCell.getStringCellValue());
                rowAsString.append(",");
            }
            if (rowAsString.length() > 0) {
                rowAsString.deleteCharAt(rowAsString.length() - 1);
            }
            String[] components = rowAsString.toString().split(",");
                for (int i = 0 ; i < components.length ; i++) {
                    if (components[i].strip().toLowerCase().equals("state")) {
                        System.out.println(components[i].strip().toLowerCase());
                        stateIndex = i;
                    } else if (components[i].strip().toLowerCase().equals("population")) {
                        System.out.println(components[i].strip().toLowerCase());
                        popIndex = i;
                    }
                }
                if (stateIndex == -1) {
                    System.out.println("State column not found - can not continue");
                    System.exit(0);
                } else if (popIndex == -1) {
                    System.out.println("Population column not found - can not continue");
                    System.exit(0);
                }
        }
        catch(FileNotFoundException e){
                System.out.println("Invalid filename - file not found");
                System.exit(0);
            } catch(IOException e){
                System.out.println("Unable to read file - IOException");
                e.printStackTrace();
                System.exit(0);
            }
            return new int[]{stateIndex, popIndex};
        }



    public static int[] CSVIndexFinder(String path) {
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
        return new int[]{stateIndex,popIndex};
    }
    public static ArrayList<String> sortedStateListMaker(ArrayList<String> list, HashMap<String,Integer> map,int stateIndex){
        ArrayList<String> stateList = new ArrayList<>();
        for(String line: list) {
            String[] components = line.split(",");
            var state = components[stateIndex].strip();
            if (map.get(state) != null && map.get(state) >0)
                stateList.add(state);
        }
        Collections.sort(stateList);
        return stateList;
    }

    public static HashMap<String, Integer> unsortedListToHashMap(ArrayList<String> list, int stateIndex, int popIndex){
        HashMap<String,Integer> dataMap = new HashMap<>();
        int lineNumber=0;
        for(String line: list){
            String[] components = line.split(",");
            try {
                if(stateIndex<components.length && popIndex<components.length && components.length>1){
                    var state = components[stateIndex].strip();
                    var population = Integer.parseInt(components[popIndex].strip());
                    if (population > 0 && state != null && state != "") {
                        dataMap.put(state, population);
                    }
                }
            }
            catch(NumberFormatException e){
                System.out.println("Line "+lineNumber+": Bad input: "+components[1].strip());
                //System.exit(0);
            }
            lineNumber++;
        }
        if (dataMap.isEmpty()){
            System.out.println("No valid data entries were found - apportionment aborted.");
            System.exit(0);
        }
        return dataMap;
    }
    public static int checkNumReps(String[] list){
        int representatives = 435;
        if (list.length>=2) try{
            int numReps = Integer.parseInt(list[1].strip());
            if(numReps<=0) {
                System.out.println("Invalid User Input - Number of representatives must be positive and nonzero");
                System.exit(0);
            }
            representatives = numReps;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid User Input - Number of representatives must be an integer");
            System.exit(0);
        }
        return representatives;
    }


  }




