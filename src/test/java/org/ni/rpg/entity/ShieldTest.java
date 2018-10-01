package org.ni.rpg.entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ni.rpg.core.enitiy.Appearance;
import org.ni.rpg.core.enitiy.Attribute;
import org.ni.rpg.core.enitiy.Dimension;
import org.ni.rpg.core.enitiy.Shield;
import org.ni.rpg.engine.singleton.GameController;
import org.ni.rpg.core.strategy.GameObjectDrawStrategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ShieldTest {

    private static Shield shield;
    private static Appearance expectedAppearance;
    private static Attribute expectedAttribute;

    @BeforeClass
    public static void initTest(){
        System.out.println("Testing starts");
        shield=new Shield(new Appearance(10, 10, new Dimension(10, 10), new Character[10][10], "RED", true, GameController.UP),
                new Attribute(true, true, true, true, true, true), 10, new GameObjectDrawStrategy());
        expectedAppearance=new Appearance(10, 10, new Dimension(10, 10), new Character[10][10], "RED", true, GameController.UP);
        expectedAttribute=new Attribute(true, true, true, true, true, true);
    }
    @Test
    public void test1(){

        assertNotNull(shield);
        assertNotNull(expectedAppearance);
        assertNotNull(expectedAttribute);


        assertEquals(expectedAppearance.getPositionX(),shield.getAppearance().getPositionX());
        assertEquals(expectedAppearance.getPositionY(),shield.getAppearance().getPositionY());
        assertEquals(expectedAppearance.getDimension().getHeight(),shield.getAppearance().getDimension().getHeight());
        assertEquals(expectedAppearance.getDimension().getWidth(),shield.getAppearance().getDimension().getWidth());
        assertEquals(expectedAppearance.getContent(),shield.getAppearance().getContent());
        assertEquals(expectedAppearance.getColor(),shield.getAppearance().getColor());
        assertEquals(expectedAppearance.isVisible(),shield.getAppearance().isVisible());

        assertEquals(expectedAttribute.isCanMove(),shield.getAttribute().isCanMove());
        assertEquals(expectedAttribute.isGoThrough(),shield.getAttribute().isGoThrough());
        assertEquals(expectedAttribute.isTakeDamage(),shield.getAttribute().isTakeDamage());
        assertEquals(expectedAttribute.isCanBeKilled(),shield.getAttribute().isCanBeKilled());
        assertEquals(expectedAttribute.isKilled(),shield.getAttribute().isKilled());
        assertEquals(expectedAttribute.isRemoveAfterKilled(),shield.getAttribute().isRemoveAfterKilled());
        System.out.println("test1 is passed");

    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing Ends");
    }
}