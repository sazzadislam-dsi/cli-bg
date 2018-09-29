package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.exception.FrameSizeOutOfBound;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameState extends GameObject {

    String playerId;

    ConcurrentHashMap<String, GameObject> gameObjects = new ConcurrentHashMap<>();

    public GameState(Appearance appearance, Attribute attribute) {
        super(appearance, attribute);
    }

    public void addGameObject(GameObject gameObject){
        gameObjects.put(gameObject.getId(),gameObject);
    }

    public void removeGameObject(GameObject gameObject){
        if(gameObjects.contains(gameObject.getId())){
            gameObjects.remove(gameObject.getId());
        }
    }

    public void removeGameObject(String gameObjectId){
        if(gameObjects.contains(gameObjectId)){
            gameObjects.remove(gameObjectId);
        }
    }

    public Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound {
        for(GameObject gameObject : gameObjects.values())
        {
            characters = gameObject.draw(characters);
        }
        return characters;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
