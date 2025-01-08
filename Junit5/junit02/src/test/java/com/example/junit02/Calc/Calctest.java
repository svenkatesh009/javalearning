package com.example.junit02.Calc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Calctest {
    @Test
    public void test(){
     Calc c=new Calc();
     int actual=c.divide(20, 2);
     int expected=10;
     assertEquals(expected, actual);
}
@Test
public void test2(){
 Calc c=new Calc();
 int actual=c.divide(30, 5);
 int expected=6;
 assertEquals(expected, actual);
}
}

