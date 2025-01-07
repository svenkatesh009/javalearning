package com.example.junit02.Calc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Calctest {
    @Test
    public void test(){
     Calc c=new Calc();
     int actual=c.divide(10, 2);
     int expected=5;
     assertEquals(expected, actual);
}
@Test
public void test2(){
 Calc c=new Calc();
 int actual=c.divide(30, 2);
 int expected=15;
 assertEquals(expected, actual);
}
}

