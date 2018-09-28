package org.nazmul.entity;

import org.nazmul.composite.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Map extends GameObject {

    List<GameObject> gameObjects = new ArrayList<>();

    public void addGameObject(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public boolean removeGameObject(GameObject gameObject){
        return gameObjects.remove(gameObject);
    }

    public char[][] draw(char[][] characters) {
        for(GameObject gameObject : gameObjects)
        {
            gameObject.draw(characters);
        }
        return characters;
    }
}
