package org.ni.rpg.entity;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AppearanceTest {


    private static int positionX;
    private static int positionY;
    private static Dimension dimension;
    private static Character[][] content;
    private static String color;
    private static boolean visible;

    private static Appearance appearance;

    private int expectedPositionX=10;
    private int expectedPositionY=20;
    private Dimension expectedDimension=new Dimension(10,20);
    private Character[][] expectedContent=new Character[10][10];
    private String expectedColor="RED";
    private boolean expectedVisible=true;

    @BeforeClass
    public static void initDimensionTest(){
        System.out.println("Testing AppearanceTest starts");
        positionX=10;
        positionY=20;
        dimension=new Dimension(10,20);
        content=new Character[10][10];
        color="RED";
        visible=true;
        appearance=new Appearance(positionX,positionY,dimension,content,color,visible);
    }
    @Test
    public void test1(){
        assertNotNull(appearance);
        assertEquals(expectedPositionX,appearance.getPositionX());
        assertEquals(expectedPositionY,appearance.getPositionY());
        assertEquals(expectedDimension.getHeight(),appearance.getDimension().getHeight());
        assertEquals(expectedDimension.getWidth(),appearance.getDimension().getWidth());
        assertEquals(expectedContent,appearance.getContent());
        assertEquals(expectedColor,appearance.getColor());
        assertEquals(expectedVisible,appearance.isVisible());

    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing AppearanceTest Ends");
    }
}
