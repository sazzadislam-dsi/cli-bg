package org.ni.rpg.composite;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;
import org.ni.rpg.entity.Dimension;
import org.ni.rpg.entity.GameState;
import org.ni.rpg.exception.FrameSizeOutOfBound;

import static org.junit.Assert.*;

public class GameObjectTest {

    private static String id;
    private static Appearance appearance;
    private static Attribute attribute;
    private static GameObject gameObject;

    private String expectedId="Nazmul";
    private static Appearance expectedPppearance;
    private static Attribute expectedAttribute;

    @BeforeClass
    public static void initTest(){
        System.out.println("Testing starts");
        id="Nazmul";
        appearance=new Appearance(10,20,new Dimension(10,20),new Character[10][10],"RED",true);
        attribute=new Attribute(true,true,true,true,true,true);
        gameObject=new GameObject(appearance,attribute) {
            @Override
            public Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound {
                return new Character[0][];
            }
        };
        gameObject.setId(id);

        expectedPppearance=new Appearance(10,20,new Dimension(10,20),new Character[10][10],"RED",true);
        expectedAttribute=new Attribute(true,true,true,true,true,true);
    }
    @Test
    public void test1(){
        assertNotNull(gameObject);
        assertNotNull(gameObject.getAppearance());
        assertNotNull(gameObject.getAttribute());
        assertNotNull(expectedPppearance);
        assertNotNull(expectedAttribute);

        assertEquals(expectedId,gameObject.getId());
        assertEquals(expectedPppearance.getPositionX(),gameObject.getAppearance().getPositionX());
        assertEquals(expectedPppearance.getPositionY(),gameObject.getAppearance().getPositionY());
        assertEquals(expectedPppearance.getDimension().getWidth(),gameObject.getAppearance().getDimension().getWidth());
        assertEquals(expectedPppearance.getDimension().getHeight(),gameObject.getAppearance().getDimension().getHeight());
        assertEquals(expectedPppearance.getContent(),gameObject.getAppearance().getContent());
        assertEquals(expectedPppearance.getColor(),gameObject.getAppearance().getColor());
        assertEquals(expectedPppearance.isVisible(),gameObject.getAppearance().isVisible());

        assertEquals(expectedAttribute.isCanMove(),gameObject.getAttribute().isCanMove());
        assertEquals(expectedAttribute.isGoThrough(),gameObject.getAttribute().isGoThrough());
        assertEquals(expectedAttribute.isTakeDamage(),gameObject.getAttribute().isTakeDamage());
        assertEquals(expectedAttribute.isCanBeKilled(),gameObject.getAttribute().isCanBeKilled());
        assertEquals(expectedAttribute.isRemoveAfterKilled(),gameObject.getAttribute().isRemoveAfterKilled());

        System.out.println("test1 is passed");
    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing Ends");
    }
}
