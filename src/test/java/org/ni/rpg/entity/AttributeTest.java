package org.ni.rpg.entity;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class AttributeTest {

    private static boolean canMove;
    private static boolean goThrough;
    private static boolean takeDamage;
    private static boolean canBeKilled;
    private static boolean killed;
    private static boolean removeAfterKilled;
    private static Attribute attribute;

    private boolean expectedCanMove=true;
    private boolean expectedGoThrough=true;
    private boolean expectedTakeDamage=true;
    private boolean expectedCanBeKilled=true;
    private boolean expectedKilled=true;
    private boolean expectedRemoveAfterKilled=false;

    @BeforeClass
    public static void initTest(){
        System.out.println("Testing starts");
        canMove=true;
        goThrough=true;
        takeDamage=true;
        canBeKilled=true;
        killed=true;
        removeAfterKilled=false;
        attribute=new Attribute(canMove,goThrough,takeDamage,canBeKilled,killed,removeAfterKilled);
    }
    @Test
    public void test1(){
        assertNotNull(attribute);
        assertEquals(expectedCanMove,attribute.isCanMove());
        assertEquals(expectedGoThrough,attribute.isGoThrough());
        assertEquals(expectedTakeDamage,attribute.isTakeDamage());
        assertEquals(expectedCanBeKilled,attribute.isCanBeKilled());
        assertEquals(expectedKilled,attribute.isKilled());
        assertEquals(expectedRemoveAfterKilled,attribute.isRemoveAfterKilled());
        System.out.println("test1 is passed");
    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing Ends");
    }

}
