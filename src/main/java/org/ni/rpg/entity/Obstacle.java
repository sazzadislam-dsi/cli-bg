package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Obstacle extends GameObject {
    private DrawStrategy drawStrategy;

    public Obstacle(Appearance appearance, Attribute attribute, DrawStrategy drawStrategy) {
        super(appearance, attribute);
        this.drawStrategy = drawStrategy;
    }

    public char[][] draw(char[][] characters) {
        return drawStrategy.draw(characters,getAppearance(),getAttribute());
    }

    @Override
    public String getName() {
        return null;
    }
}
