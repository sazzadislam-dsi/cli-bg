package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Shield extends GameObject {
    private static final long serialversionUID = 538219551L;

    private double protection;
    private DrawStrategy drawStrategy;

    public Shield(Appearance appearance, Attribute attribute, double protection, DrawStrategy drawStrategy) {
        super(appearance, attribute);
        this.protection = protection;
        this.drawStrategy = drawStrategy;
    }

    public Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound {
        return drawStrategy.draw(characters,this);
    }

}
