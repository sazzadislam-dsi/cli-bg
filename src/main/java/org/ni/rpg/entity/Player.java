package org.ni.rpg.entity;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.strategy.DrawStrategy;

/**
 * Created by nazmul on 9/29/2018.
 */
public class Player extends GameObject {

    private String name;
    private String description;
    private double health;
    private char direction;
    private Weapon weapon;
    private Shield shield;
    private DrawStrategy drawStrategy;

    public Player(Appearance appearance, Attribute attribute, String name, String description, double health, char direction, Weapon weapon, Shield shield, DrawStrategy drawStrategy) {
        super(appearance, attribute);
        this.name = name;
        this.description = description;
        this.health = health;
        this.direction = direction;
        this.weapon = weapon;
        this.shield = shield;
        this.drawStrategy = drawStrategy;
    }

    public Character[][] draw(Character[][] characters) {
        return drawStrategy.draw(characters,getAppearance(),getAttribute());
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
