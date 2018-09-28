package org.nazmul.entity;

import org.nazmul.composite.GameObject;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Player extends GameObject {

    String name;
    String description;
    double health;
    char direction;

    public char[][] draw(char[][] characters) {
        return characters;
    }

}
