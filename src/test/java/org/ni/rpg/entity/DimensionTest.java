package org.ni.rpg.entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ni.rpg.core.enitiy.Dimension;

import static org.junit.Assert.*;

public class DimensionTest {
    private static int height;
    private static int width;
    private int expectedHeight=10;
    private int expectedWidth=20;

    private static Dimension dimension;

    @BeforeClass
    public static void initTest(){
        System.out.println("Testing starts");
        height=10;
        width=20;
        dimension=new Dimension(height,width);
    }
    @Test
    public void test1(){

        assertNotNull(dimension);
        assertEquals(expectedHeight,dimension.getHeight());
        assertEquals(expectedWidth,dimension.getWidth());
    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing ends");
    }
}
