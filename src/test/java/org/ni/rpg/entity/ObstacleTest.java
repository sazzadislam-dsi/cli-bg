package org.ni.rpg.entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.singleton.GameController;
import org.ni.rpg.strategy.DrawStrategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ObstacleTest {

    private static Obstacle obstacle;
    private static Appearance expectedAppearance;
    private  static Attribute expectedAttribute;

    @BeforeClass
    public static void initTest(){
        System.out.println("Testing starts");
        obstacle=new Obstacle(new Appearance(10, 10, new Dimension(10, 10), new Character[10][10], "RED", true, GameController.UP),
                new Attribute(true, true, true, true, true, true), new DrawStrategy() {
            @Override
            public Character[][] draw(Character[][] characters, Appearance appearance, Attribute attribute) throws FrameSizeOutOfBound {
                return new Character[0][];
            }
        });

        expectedAppearance= new Appearance(10, 10, new Dimension(10, 10), new Character[10][10], "RED", true, GameController.UP);
        expectedAttribute=new Attribute(true, true, true, true, true, true);
    }
    @Test
    public void test1(){
        assertNotNull(obstacle);
        assertNotNull(expectedAppearance);
        assertNotNull(expectedAttribute);

        assertEquals(expectedAppearance.getPositionX(),obstacle.getAppearance().getPositionX());
        assertEquals(expectedAppearance.getPositionY(),obstacle.getAppearance().getPositionY());
        assertEquals(expectedAppearance.getDimension().getHeight(),obstacle.getAppearance().getDimension().getHeight());
        assertEquals(expectedAppearance.getDimension().getWidth(),obstacle.getAppearance().getDimension().getWidth());
        assertEquals(expectedAppearance.getContent(),obstacle.getAppearance().getContent());
        assertEquals(expectedAppearance.getColor(),obstacle.getAppearance().getColor());
        assertEquals(expectedAppearance.isVisible(),obstacle.getAppearance().isVisible());

        assertEquals(expectedAttribute.isCanMove(),obstacle.getAttribute().isCanMove());
        assertEquals(expectedAttribute.isGoThrough(),obstacle.getAttribute().isGoThrough());
        assertEquals(expectedAttribute.isTakeDamage(),obstacle.getAttribute().isTakeDamage());
        assertEquals(expectedAttribute.isCanBeKilled(),obstacle.getAttribute().isCanBeKilled());
        assertEquals(expectedAttribute.isKilled(),obstacle.getAttribute().isKilled());
        assertEquals(expectedAttribute.isRemoveAfterKilled(),obstacle.getAttribute().isRemoveAfterKilled());

        System.out.println("test1 is passed");

    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing Ends");
    }
}
