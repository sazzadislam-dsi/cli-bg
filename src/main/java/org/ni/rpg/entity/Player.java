package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Player extends GameObject {
    private static final long serialversionUID = 538219553L;

    private String name;
    private String description;
    private double health;
    private char direction;
    private Weapon weapon;
    private Shield shield;
    private DrawStrategy drawStrategy;
    private int speed;

    private String UP;
    private String LEFT;
    private String RIGHT;
    private String DOWN;

    public Player(Appearance appearance, Attribute attribute, String name, String description, double health, char direction, Weapon weapon, Shield shield, DrawStrategy drawStrategy,int speed) {
        super(appearance, attribute);
        this.name = name;
        this.description = description;
        this.health = health;
        this.direction = direction;
        this.weapon = weapon;
        this.shield = shield;
        this.drawStrategy = drawStrategy;
        this.speed = speed;
    }

    public Character[][] draw(Character[][] contents) throws FrameSizeOutOfBound {
        return drawStrategy.draw(contents, getAppearance(), getAttribute());
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Shield getShield() {
        return shield;
    }

    public void setShield(Shield shield) {
        this.shield = shield;
    }

    public DrawStrategy getDrawStrategy() {
        return drawStrategy;
    }

    public void setDrawStrategy(DrawStrategy drawStrategy) {
        this.drawStrategy = drawStrategy;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", health=" + health +
                ", direction=" + direction +
                ", weapon=" + weapon +
                ", shield=" + shield +
                ", drawStrategy=" + drawStrategy +
                '}';
    }
}
