package org.ni.rpg.core.strategy;

import org.ni.rpg.core.composite.GameObject;

/**
 * Created by nazmul on 9/29/2018.
 */
public class VoidDrawStrategy implements DrawStrategy {
    @Override
    public Character[][] draw(Character[][] characters, GameObject gameObject) {
        return characters;
    }
}
