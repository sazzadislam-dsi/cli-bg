package org.nazmul.entity;

import org.nazmul.composite.GameObject;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Weapon extends GameObject {

    double attack;
    int range;

    public char[][] draw(char[][] characters) {
        return new char[0][];
    }
}
