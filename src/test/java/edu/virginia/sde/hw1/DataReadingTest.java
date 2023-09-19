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
    //path = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/example1.csv";

   }
 // Data Reading Testing:
 @Test
   public void excelFileToHashMapTest(){
    HashMap<String,Integer> dataMap = new HashMap<>();
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
    dataMap.put("Alabama",5030053);
    dataMap.put("Alaska",736081);
    dataMap.put("Arizona",7158923);
    dataMap.put("Arkansas",3013756);
    dataMap.put("California",39576757);
    dataMap.put("Colorado",5782171);
    dataMap.put("Connecticut",3608298);
    dataMap.put("Delaware",990837);
    dataMap.put("Florida",21570527);
    assertEquals(dataMap, DataReading.excelFileToHashMap(list,0,0));
   }
   @Test
   public void csvFileToHashMap(){
    HashMap<String,Integer> dataMap = new HashMap<>();
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
    dataMap.put("Alabama",5030053);
    dataMap.put("Alaska",736081);
    dataMap.put("Arizona",7158923);
    dataMap.put("Arkansas",3013756);
    dataMap.put("California",39576757);
    dataMap.put("Colorado",5782171);
    dataMap.put("Connecticut",3608298);
    dataMap.put("Delaware",990837);
    dataMap.put("Florida",21570527);
    assertEquals(dataMap, DataReading.csvFileToHashMap(list,0,1));
   }
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
    //normal input
    @Test
    public void excelReaderCheck1(){
    String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/lessStatePopulations.xlsx";
    //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/lessStatePopulations.xlsx";
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
    String file = "lost";
     ArrayList<String> result = new ArrayList<>();
     result.add("Alabama,5030053");
     result.add("Alaska,736081");
     result.add("Arizona,7158923");
     result.add("Arkansas,3013756");
     assertEquals(result, dataRead.excelReader(file));
    }

    //normal input
    @Test
    public void csvFileReader1(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations.csv";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulations.csv";
     ArrayList<String> result = new ArrayList<>();
     result.add("Alabama,5030053");
     result.add("Alaska,736081");
     result.add("Arizona,7158923");
     result.add("Arkansas,3013756");
     assertEquals(result, dataRead.csvFileReader(file));
    }
    //error: file is empty
    @Test
    public void csvFileReader2(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/empty.csv";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/empty.csv";
     ArrayList<String> result = new ArrayList<>();
     result.add("Alabama,5030053");
     result.add("Alaska,736081");
     result.add("Arizona,7158923");
     result.add("Arkansas,3013756");
     assertEquals(result, dataRead.csvFileReader(file));
    }
    //error: invalid filename
    @Test
    public void csvFileReader3(){
     String file = "file";
     ArrayList<String> result = new ArrayList<>();
     result.add("Alabama,5030053");
     result.add("Alaska,736081");
     result.add("Arizona,7158923");
     result.add("Arkansas,3013756");
     assertEquals(result, dataRead.csvFileReader(file));
    }

    //normal input
    @Test
    public void readFileCheck1(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations.csv";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulations.csv";
     ArrayList<String> result = new ArrayList<>();
     result.add("Alabama,5030053");
     result.add("Alaska,736081");
     result.add("Arizona,7158923");
     result.add("Arkansas,3013756");
     assertEquals(result, dataRead.readFile(file));
     String file2 = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/lessStatePopulations.xlsx";
     //String file2 = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/lessStatePopulations.xlsx";
     ArrayList<String> result2 = new ArrayList<>();
     result2.add("Alabama,5030053");
     result2.add("Alaska,736081");
     result2.add("Arizona,7158923");
     result2.add("Arkansas,3013756");
     assertEquals(result, dataRead.readFile(file2));
    }
    //error: file type invalid
    @Test
    public void readFileCheck2(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/file.txt";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/file.txt";
     ArrayList<String> result = new ArrayList<>();
     result.add("Alabama,5030053");
     result.add("Alaska,736081");
     result.add("Arizona,7158923");
     result.add("Arkansas,3013756");
     assertEquals(result, dataRead.readFile(file));
    }
    //normal implementation
    @Test
    public void excelIndexFinderCheck1(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations_mixed_columns.xlsx";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulations_mixed_columns.xlsx";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.excelIndexFinder(file));
    }
    //error: no state column found
    @Test
    public void excelIndexFinderCheck2(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations_noStates.xlsx";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulations_noStates.xlsx";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.excelIndexFinder(file));
    }
    //error: no population column found
    @Test
    public void excelIndexFinderCheck3(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations_noPop.xlsx";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulations_noPop.xlsx";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.excelIndexFinder(file));
    }
    //error: invalid filename
    @Test
    public void excelIndexFinderCheck4(){
     String file = "blank";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.excelIndexFinder(file));
    }
    //normal implementation
    @Test
    public void CSVIndexFinderCheck1(){
    String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulations_mixed_columns.csv";
    //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulations_mixed_columns.csv";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.CSVIndexFinder(file));
    }
    //error: no state column found
    @Test
    public void CSVIndexFinderCheck2(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulationsNoState.csv";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulationsNoState.csv";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.CSVIndexFinder(file));
    }
    //error: no population column found
    @Test
    public void CSVIndexFinderCheck3(){
     String file = "/Users/christinayang/IdeaProjects/HW1workaround/src/test/resources/statePopulationsNoPop.csv";
     //String file = "/Users/Eric/IdeaProjects/HW1workaround/src/test/resources/statePopulationsNoPop.csv";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.CSVIndexFinder(file));
    }
    //error: invalid filename
    @Test
    public void CSVIndexFinderCheck4(){
     String file = "blank";
     int[] result = {1,3};
     assertArrayEquals(result, dataRead.CSVIndexFinder(file));
    }

}
