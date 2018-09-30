package org.ni.rpg.strategy;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.Appearance;
import org.ni.rpg.entity.Attribute;
import org.ni.rpg.exception.FrameSizeOutOfBound;

/**
 * Created by nazmul on 9/29/2018.
 */
public interface DrawStrategy {
    Character[][] draw(Character[][] characters, GameObject gameObject) throws FrameSizeOutOfBound;
}
