package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameMap extends GameObject {

    ConcurrentHashMap<String, GameObject> gameObjects = new ConcurrentHashMap<>();

    public GameMap(Appearance appearance, Attribute attribute) {
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

    public Character[][] draw(Character[][] characters) {
        for(GameObject gameObject : gameObjects.values())
        {
            gameObject.draw(characters);
        }
        return characters;
    }
}
