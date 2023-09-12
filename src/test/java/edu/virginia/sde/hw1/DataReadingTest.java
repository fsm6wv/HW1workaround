package edu.virginia.sde.hw1;

import java.io.*;
import java.util.*;
import org.junit.jupiter.api.BeforeAll;
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
        assertEquals(list, dataRead.ListMaker(path));
    }
    // sortedStateListMaker
 //   @Test
//    public void sortedTest(){
//        ArrayList<String> list = new ArrayList<>();
//        list.add("Arkansas,3013756");
//        list.add("Alaska,736081");
//        list.add("Arizona,7158923");
//        list.add("Delaware,990837");
//        list.add("Colorado,5782171");
//        list.add("Connecticut,3608298");
//        list.add("Alabama,5030053");
//        list.add("Florida,21570527");
//        list.add("California,39576757");
//        ArrayList<String> result = new ArrayList<>();
//        result.add("Alabama");
//        result.add("Alaska");
//        result.add("Arizona");
//        result.add("Arkansas");
//        result.add("California");
//        result.add("Colorado");
//        result.add("Connecticut");
//        result.add("Delaware");
//        result.add("Florida");
//        assertEquals(result, dataRead.sortedStateListMaker(list));
//    }

    //listToHashMap
    @Test
    public void listToHMCheck(){
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
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alabama",5030053);
        map.put("Alaska",736081);
        map.put("Arizona",7158923);
        map.put("Arkansas",3013756);
        map.put("California",39576757);
        map.put("Colorado",5782171);
        map.put("Connecticut",3608298);
        map.put("Delaware",990837);
        map.put("Florida",21570527);
        assertEquals(map, dataRead.ListToHashMap(list));

    }
    //testing listToHashMap with ListMaker method
    @Test
    public void listToHMCheck1(){
       ArrayList<String> list = dataRead.ListMaker(path);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alabama",5030053);
        map.put("Alaska",736081);
        map.put("Arizona",7158923);
        map.put("Arkansas",3013756);
        map.put("California",39576757);
        map.put("Colorado",5782171);
        map.put("Connecticut",3608298);
        map.put("Delaware",990837);
        map.put("Florida",21570527);
        assertEquals(map, dataRead.ListToHashMap(list));
    }
    //checkNumReps
    /*@Test
    public void checkNumRepsTest(){
        JeffersonApportionment jeff = new JeffersonApportionment();
        ArrayList<String> list = dataRead.ListMaker(path);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alabama",5030053);
        map.put("Alaska",736081);
        map.put("Arizona",7158923);
        map.put("Arkansas",3013756);
        map.put("California",39576757);
        map.put("Colorado",5782171);
        map.put("Connecticut",3608298);
        map.put("Delaware",990837);
        map.put("Florida",21570527);
        HashMap<String, Integer> actual = jeff.makeRepNMap(dataRead.sortedStateListMaker(list, map), map,115);
        //calculate
        int expected = 115;
        assertEquals(expected, actual.values());

    }*/
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

}
