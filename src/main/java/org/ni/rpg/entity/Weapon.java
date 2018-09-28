package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Weapon extends GameObject {

    double attack;
    int range;
    DrawStrategy drawStrategy;

    public Weapon(int positionX, int positionY, int height, int width, char[][] content, String color, Attribute attribute, double attack, int range, DrawStrategy drawStrategy) {
        super(positionX, positionY, height, width, content, color, attribute);
        this.attack = attack;
        this.range = range;
        this.drawStrategy = drawStrategy;
    }

    public char[][] draw(char[][] characters) {
        return drawStrategy.draw(characters);
    }
}
