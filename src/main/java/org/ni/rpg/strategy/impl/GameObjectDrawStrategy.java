package org.ni.rpg.strategy.impl;

import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameObjectDrawStrategy implements DrawStrategy {
    @Override
    public Character[][] draw(Character[][] characters, Appearance appearance, Attribute attribute) {
        return characters;
    }
}
