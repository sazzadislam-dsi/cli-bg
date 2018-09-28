package org.nazmul.entity;

import org.nazmul.composite.GameObject;
import org.nazmul.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Obstacle extends GameObject {
    DrawStrategy drawStrategy;

    public Obstacle(int positionX, int positionY, int height, int width, char[][] content, String color, Attribute attribute, DrawStrategy drawStrategy) {
        super(positionX, positionY, height, width, content, color, attribute);
        this.drawStrategy = drawStrategy;
    }

    public char[][] draw(char[][] characters) {
        return drawStrategy.draw(characters);
    }

}
