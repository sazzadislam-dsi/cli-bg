package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Weapon extends GameObject {
    private static final long serialversionUID = 538219550L;

    private double attack;
    private int range;
    private DrawStrategy drawStrategy;

    public Weapon(Appearance appearance, Attribute attribute, double attack, int range, DrawStrategy drawStrategy) {
        super(appearance, attribute);
        this.attack = attack;
        this.range = range;
        this.drawStrategy = drawStrategy;
    }

    public Character[][] draw(Character[][] characters) throws FrameSizeOutOfBound {
        return drawStrategy.draw(characters,getAppearance(),getAttribute());
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
