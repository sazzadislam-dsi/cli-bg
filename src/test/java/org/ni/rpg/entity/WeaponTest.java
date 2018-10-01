package org.ni.rpg.entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ni.rpg.core.enitiy.Appearance;
import org.ni.rpg.core.enitiy.Attribute;
import org.ni.rpg.core.enitiy.Dimension;
import org.ni.rpg.core.enitiy.Weapon;
import org.ni.rpg.engine.singleton.GameController;
import org.ni.rpg.core.strategy.GameObjectDrawStrategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WeaponTest {

    private static Weapon weapon;
    private static Appearance expectedAppearance;
    private  static Attribute expectedAttribute;


    @BeforeClass
    public static void initTest(){
        System.out.println("Testing starts");

        weapon=new Weapon(new Appearance(10, 10, new Dimension(10, 10), new Character[10][10], "RED", true, GameController.UP),
                new Attribute(true, true, true, true, true, true),10,10, new GameObjectDrawStrategy());

        expectedAppearance= new Appearance(10, 10, new Dimension(10, 10), new Character[10][10], "RED", true, GameController.UP);
        expectedAttribute=new Attribute(true, true, true, true, true, true);
    }
    @Test
    public void test1(){

        assertNotNull(weapon);
        assertNotNull(expectedAppearance);
        assertNotNull(expectedAttribute);

        assertEquals(expectedAppearance.getPositionX(),weapon.getAppearance().getPositionX());
        assertEquals(expectedAppearance.getPositionY(),weapon.getAppearance().getPositionY());
        assertEquals(expectedAppearance.getDimension().getHeight(),weapon.getAppearance().getDimension().getHeight());
        assertEquals(expectedAppearance.getDimension().getWidth(),weapon.getAppearance().getDimension().getWidth());
        assertEquals(expectedAppearance.getContent(),weapon.getAppearance().getContent());
        assertEquals(expectedAppearance.getColor(),weapon.getAppearance().getColor());
        assertEquals(expectedAppearance.isVisible(),weapon.getAppearance().isVisible());

        assertEquals(expectedAttribute.isCanMove(),weapon.getAttribute().isCanMove());
        assertEquals(expectedAttribute.isGoThrough(),weapon.getAttribute().isGoThrough());
        assertEquals(expectedAttribute.isTakeDamage(),weapon.getAttribute().isTakeDamage());
        assertEquals(expectedAttribute.isCanBeKilled(),weapon.getAttribute().isCanBeKilled());
        assertEquals(expectedAttribute.isKilled(),weapon.getAttribute().isKilled());
        assertEquals(expectedAttribute.isRemoveAfterKilled(),weapon.getAttribute().isRemoveAfterKilled());

        System.out.println("test1 is passed");
    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing Ends");
    }

}