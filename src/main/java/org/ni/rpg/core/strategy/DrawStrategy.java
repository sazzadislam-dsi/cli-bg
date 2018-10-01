package org.ni.rpg.core.strategy;

import org.ni.rpg.core.composite.GameObject;
import org.ni.rpg.exception.FrameSizeOutOfBound;

/**
 * Created by nazmul on 9/29/2018.
 */
public interface DrawStrategy {
    Character[][] draw(Character[][] characters, GameObject gameObject) throws FrameSizeOutOfBound;
}
