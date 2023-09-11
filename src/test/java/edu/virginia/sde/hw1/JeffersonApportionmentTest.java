package edu.virginia.sde.hw1;

import java.util.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JeffersonApportionmentTest {
    // Jefferson Apportionment Testing:
    // getTotalPopulation()
    @Test
    public void getTotalPopulationTest() {
        var jeff = new JeffersonApportionment();
        // putting data from sample code into hashmap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alabama", 5030053);
        map.put("Alaska", 736081);
        map.put("Arizona", 7158923);
        map.put("Arkansas", 3013756);
        ArrayList<String> list = new ArrayList<>();
        list.add("Alabama");
        list.add("Alaska");
        list.add("Arizona");
        list.add("Arkansas");
        assertEquals(15938813, jeff.getTotalPopulation(list, map));
    }

   @Test
    public void findDivisorTest(){
        JeffersonApportionment jeff = new JeffersonApportionment();
       HashMap<String, Integer> map = new HashMap<>();
       map.put("Alabama", 5030053);
       map.put("Alaska", 736081);
       map.put("Arizona", 7158923);
       ArrayList<String> list = new ArrayList<>();
       list.add("Alabama");
       list.add("Alaska");
       list.add("Arizona");
       double result = 718565.0401803779;
       assertEquals(result, jeff.findDivisor(list, map, 17));
   }


    @Test
    public void makeRepMapTest(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alabama", 5030053);
        map.put("Arkansas", 3013756);
        map.put("Alaska", 736081);
        map.put("Arizona", 7158923);
        map.put("Colorado", 5782171);
        ArrayList<String> list = new ArrayList<>();
        list.add("Alabama");
        list.add("Arkansas");
        list.add("Alaska");
        list.add("Arizona");
        list.add("Colorado");
        HashMap<String, Integer> solution = new HashMap<>();
        solution.put("Alabama", 7);
        solution.put("Arkansas", 4);
        solution.put("Alaska", 1);
        solution.put("Arizona", 10);
        solution.put("Colorado", 8);
        assertEquals(solution, JeffersonApportionment.makeRepNMap(list,map,30));
    }
}
