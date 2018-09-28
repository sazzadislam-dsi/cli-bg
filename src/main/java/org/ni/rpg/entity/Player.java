package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Player extends GameObject {

    String name;
    String description;
    double health;
    char direction;
    Weapon weapon;
    Shield shield;
    DrawStrategy drawStrategy;

    public Player(int positionX, int positionY, int height, int width, char[][] content, String color, Attribute attribute, String name, String description, double health, char direction, Weapon weapon, Shield shield, DrawStrategy drawStrategy) {
        super(positionX, positionY, height, width, content, color, attribute);
        this.name = name;
        this.description = description;
        this.health = health;
        this.direction = direction;
        this.weapon = weapon;
        this.shield = shield;
        this.drawStrategy = drawStrategy;
    }

    public char[][] draw(char[][] characters) {
        return drawStrategy.draw(characters);
    }

}
