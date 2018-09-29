package org.ni.rpg.strategy;

import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;

/**
 * Created by nazmul on 9/29/2018.
 */
public interface DrawStrategy {
    Character[][] draw(Character[][] characters, Appearance appearance, Attribute attribute);
}
