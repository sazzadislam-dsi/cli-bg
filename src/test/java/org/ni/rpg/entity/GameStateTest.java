package org.ni.rpg.entity;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ni.rpg.composite.GameObject;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.singleton.GameController;

import static org.junit.Assert.*;

public class GameStateTest {

    private static String playerId;
    private static GameState gameState;
    private static GameObject gameObject;


    private static String expectedPlayerId="Nazmul";
    private static GameObject expectedGameObject;


    @BeforeClass
    public static void initTest(){
        System.out.println("Testing starts");
        playerId="Nazmul";
        gameState=new GameState(new Appearance(10,10,new Dimension(10,10),
                new Character[10][10],"RED",true, GameController.UP),new Attribute(true,true,true,true,true,true));

        gameState.setPlayerId(playerId);
        gameObject=new GameObject(new Appearance(10,20,new Dimension(10,20),new Character[10][10],"RED",true, GameController.UP),
                new Attribute(true,true,true,true,true,true)) {
            @Override
            public Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound {
                return new Character[0][];
            }
        };
        gameObject.setId(playerId);
        gameState.addGameObject(gameObject);

        expectedGameObject=new GameObject(new Appearance(10,20,new Dimension(10,20),new Character[10][10],"RED",true, GameController.UP),
                new Attribute(true,true,true,true,true,true)) {
            @Override
            public Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound {
                return new Character[0][];
            }
        };
        expectedGameObject.setId(expectedPlayerId);
    }
    @Test
    public void test1(){
        
        System.out.println("test1 is passed");
        assertNotNull(gameObject);
        assertNotNull(gameState);
        assertNotNull(gameState.getGameObjct("Nazmul"));

        assertEquals(expectedPlayerId,gameState.getPlayerId());
        assertEquals(expectedGameObject.getId(),gameState.getGameObjct(playerId).getId());
        assertEquals(expectedGameObject.getAttribute().isCanMove(),gameState.getGameObjct(playerId).getAttribute().isCanMove());
        assertEquals(expectedGameObject.getAttribute().isGoThrough(),gameState.getGameObjct(playerId).getAttribute().isGoThrough());
        assertEquals(expectedGameObject.getAttribute().isTakeDamage(),gameState.getGameObjct(playerId).getAttribute().isTakeDamage());
        assertEquals(expectedGameObject.getAttribute().isCanBeKilled(),gameState.getGameObjct(playerId).getAttribute().isCanBeKilled());
        assertEquals(expectedGameObject.getAttribute().isKilled(),gameState.getGameObjct(playerId).getAttribute().isKilled());
        assertEquals(expectedGameObject.getAttribute().isRemoveAfterKilled(),gameState.getGameObjct(playerId).getAttribute().isRemoveAfterKilled());

        assertEquals(expectedGameObject.getAppearance().getPositionX(),gameState.getGameObjct(playerId).getAppearance().getPositionX());
        assertEquals(expectedGameObject.getAppearance().getPositionY(),gameState.getGameObjct(playerId).getAppearance().getPositionY());
        assertEquals(expectedGameObject.getAppearance().getDimension().getHeight(),gameState.getGameObjct(playerId).getAppearance().getDimension().getHeight());
        assertEquals(expectedGameObject.getAppearance().getDimension().getWidth(),gameState.getGameObjct(playerId).getAppearance().getDimension().getWidth());
        assertEquals(expectedGameObject.getAppearance().getContent(),gameState.getGameObjct(playerId).getAppearance().getContent());
        assertEquals(expectedGameObject.getAppearance().getColor(),gameState.getGameObjct(playerId).getAppearance().getColor());
        assertEquals(expectedGameObject.getAppearance().isVisible(),gameState.getGameObjct(playerId).getAppearance().isVisible());
    }
    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing Ends");
    }

}
