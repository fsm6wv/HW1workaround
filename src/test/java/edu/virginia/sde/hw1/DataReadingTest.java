package edu.virginia.sde.hw1;

import java.sql.Array;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataReadingTest {
    DataReading dataRead;
    String path;

   @BeforeEach
    public void setUp(){
       dataRead = new DataReading();
       path = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/example1.csv";
   }
    // Data Reading Testing:
    // listMaker
    @Test
    public void listMakerTest(){
        ArrayList<String> list = new ArrayList<>();
        list.add("Alabama,5030053");
        list.add("Alaska,736081");
        list.add("Arizona,7158923");
        list.add("Arkansas,3013756");
        list.add("California,39576757");
        list.add("Colorado,5782171");
        list.add("Connecticut,3608298");
        list.add("Delaware,990837");
        list.add("Florida,21570527");
        assertEquals(list, dataRead.csvFileReader(path));
    }

    //listToHashMap
//    @Test
//    public void listToHMCheck(){
//        ArrayList<String> list = new ArrayList<>();
//        list.add("Alabama,5030053");
//        list.add("Alaska,736081");
//        list.add("Arizona,7158923");
//        list.add("Arkansas,3013756");
//        list.add("California,39576757");
//        list.add("Colorado,5782171");
//        list.add("Connecticut,3608298");
//        list.add("Delaware,990837");
//        list.add("Florida,21570527");
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("Alabama",5030053);
//        map.put("Alaska",736081);
//        map.put("Arizona",7158923);
//        map.put("Arkansas",3013756);
//        map.put("California",39576757);
//        map.put("Colorado",5782171);
//        map.put("Connecticut",3608298);
//        map.put("Delaware",990837);
//        map.put("Florida",21570527);
//        assertEquals(map, dataRead.ListToHashMap(list));
//
//    }
    //testing listToHashMap with ListMaker method
   // @Test
//    public void listToHMCheck1(){
//       ArrayList<String> list = dataRead.ListMaker(path);
//        HashMap<String, Integer> map = new HashMap<>();
//        map.put("Alabama",5030053);
//        map.put("Alaska",736081);
//        map.put("Arizona",7158923);
//        map.put("Arkansas",3013756);
//        map.put("California",39576757);
//        map.put("Colorado",5782171);
//        map.put("Connecticut",3608298);
//        map.put("Delaware",990837);
//        map.put("Florida",21570527);
//        assertEquals(map, dataRead.ListToHashMap(list));
//    }
    @Test
    public void checkNumRepsTest1(){
        String[] list1 = {"0","16"};
        assertEquals(16, dataRead.checkNumReps(list1));
    }
    @Test
    public void checkNumRepsTest2(){
        String[] list2 = {"0", "-2"};
        assertFalse(-2 == dataRead.checkNumReps(list2));
    }
    @Test
    public void checkNumRepsTest3(){
        String[] list3 = {"0", "a"};
        assertFalse(0 == dataRead.checkNumReps(list3));
    }
    // numOfReps
//   @Test
//    public void numOfRepsTest(){
//       // for length 2 (valid)
//       assertEquals(14, DataReading.numOfReps("14", 2));
//       // for length !2 (invalid)
//       assertEquals(435, DataReading.numOfReps("1", 1));
//   }
    //is excel file
    @Test
    public void isExcelCheck1(){
       String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations.xlsx";
        assertTrue(dataRead.isExcel(file));

    }
    //not excel file
    @Test
    public void isExcelCheck2(){
        String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations_mixed_columns.csv";
        assertFalse(dataRead.isExcel(file));
    }
    //is csv file
    @Test
    public void isCSVCheck1(){
       String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations_mixed_columns.csv";
        assertTrue(dataRead.isCSV(file));
    }
    //is not csv file
    @Test
    public void isCSVCheck2(){
        String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations.xlsx";
        assertFalse(dataRead.isCSV(file));
    }
    //normal input - String (state)
    @Test
    public void getCellStringValueCheck1(){

    }
    //normal input - numeric (population)
    @Test
    public void getCellStringValueCheck2(){

    }
    //normal input
    @Test
    public void excelReaderCheck1(){
    String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/lessStatePopulations.xlsx";
     ArrayList<String> result = new ArrayList<>();
     result.add("Alabama,5030053");
     result.add("Alaska,736081");
     result.add("Arizona,7158923");
     result.add("Arkansas,3013756");
     assertEquals(result, dataRead.excelReader(file));
    }
    //error: invalid filename
    @Test
    public void excelReaderCheck2(){

    }
    //error: unable to read file
    @Test
    public void excelReaderCheck3(){

    }
    //normal input
    @Test
    public void csvFileReader1(){

    }
    //error: file is empty
    @Test
    public void csvFileReader2(){

    }
    //error: invalid filename
    @Test
    public void csvFileReader3(){

    }
    //error: unable to read file
    @Test
    public void csvFileReader4(){

    }
    //normal input
    @Test
    public void readFileCheck1(){

    }
    //error: file type invalid
    @Test
    public void readFileCheck2(){

    }
    //normal implementation
    @Test
    public void excelIndexFinderCheck1(){

    }
    //error: no state column found
    @Test
    public void excelIndexFinderCheck2(){

    }
    //error: no population column found
    @Test
    public void excelIndexFinderCheck3(){

    }
    //error: invalid filename
    @Test
    public void excelIndexFinderCheck4(){

    }
    //error: unable to read file
    @Test
    public void excelIndexFinderCheck5(){

    }
    //normal implementation
    @Test
    public void CSVIndexFinderCheck1(){

    }
    //error: no state column found
    @Test
    public void CSVIndexFinderCheck2(){

    }
    //error: no population column found
    @Test
    public void CSVIndexFinderCheck3(){

    }
    //error: invalid filename
    @Test
    public void CSVIndexFinderCheck4(){

    }
    //error: unable to read file
    @Test
    public void CSVIndexFinderCheck5(){

    }
    //normal implementation
    @Test
    public void unsortedListToHashmapCheck1(){

    }
    //error: bad input
    @Test
    public void unsortedListToHashmapCheck2(){

    }
    //error: no valid entries found
    @Test
    public void unsortedListToHashmapCheck3(){

    }
}
