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
    public char[][] draw(char[][] characters) {
        return drawStrategy.draw(characters);
    }

}
