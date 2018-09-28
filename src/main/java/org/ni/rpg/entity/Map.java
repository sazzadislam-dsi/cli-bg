package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Map extends GameObject {

    List<GameObject> gameObjects = new ArrayList<>();

    public Map(int positionX, int positionY, int height, int width, char[][] content, String color, Attribute attribute) {
        super(positionX, positionY, height, width, content, color, attribute);

    }

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
