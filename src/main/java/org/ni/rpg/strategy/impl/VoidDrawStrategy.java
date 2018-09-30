package org.ni.rpg.strategy.impl;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class VoidDrawStrategy implements DrawStrategy {
    @Override
    public Character[][] draw(Character[][] characters, GameObject gameObject) {
        return characters;
    }
}
