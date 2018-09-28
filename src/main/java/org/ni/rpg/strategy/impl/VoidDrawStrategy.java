package org.ni.rpg.strategy.impl;

import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class VoidDrawStrategy implements DrawStrategy {
    @Override
    public char[][] draw(char[][] characters) {
        return characters;
    }
}
