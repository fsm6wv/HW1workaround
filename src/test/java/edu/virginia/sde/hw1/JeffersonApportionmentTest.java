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

    // findDivisor()
    @Test
    public void findDivisorTest(){
        // putting data from sample code into hashmap
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Alabama", 5030053);
        map.put("Arkansas", 3013756);
        ArrayList<String> list = new ArrayList<>();
        list.add("Alabama");
        list.add("Arkansas");

        int divisor = 658129;
        assertEquals(divisor, JeffersonApportionment.findDivisor(list, map, 11));

    }
}
