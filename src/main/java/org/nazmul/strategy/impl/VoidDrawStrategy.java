package org.nazmul.strategy.impl;

import org.nazmul.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class VoidDrawStrategy implements DrawStrategy {
    @Override
    public char[][] draw(char[][] characters) {
        return characters;
    }
}
