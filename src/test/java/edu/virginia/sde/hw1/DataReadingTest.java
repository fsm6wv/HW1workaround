package edu.virginia.sde.hw1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataReadingTest {
    DataReading dataRead;
   @BeforeEach
    public void setUp(){
       dataRead = new DataReading();
   }
    // Data Reading Testing:
    // numOfReps
   @Test
    public void numOfRepsTest(){
       // for length 2 (valid)
       assertEquals(14, DataReading.numOfReps("14", 2));
       // for length !2 (invalid)
       assertEquals(435, DataReading.numOfReps("1", 1));
   }
}
