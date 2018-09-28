package org.nazmul.entity;

import org.nazmul.composite.GameObject;
import org.nazmul.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Player extends GameObject {

    String name;
    String description;
    double health;
    char direction;
    DrawStrategy drawStrategy;

    public Player(int positionX, int positionY, int height, int width, char[][] content, String color, Attribute attribute, String name, String description, double health, char direction, DrawStrategy drawStrategy) {
        super(positionX, positionY, height, width, content, color, attribute);
        this.name = name;
        this.description = description;
        this.health = health;
        this.direction = direction;
        this.drawStrategy = drawStrategy;
    }

    public char[][] draw(char[][] characters) {
        return drawStrategy.draw(characters);
    }

}
