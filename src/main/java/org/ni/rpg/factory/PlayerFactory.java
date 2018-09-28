package org.ni.rpg.factory;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.*;
import org.ni.rpg.factory.GameObjectAbstractFactory;
import org.ni.rpg.strategy.DrawStrategy;

public class PlayerFactory implements GameObjectAbstractFactory {
    private String name;
    private String description;
    private double health;
    private char direction;
    private Weapon weapon;
    private Shield shield;
    private DrawStrategy drawStrategy;
    private Appearance appearance;
    private Attribute attribute;

    public PlayerFactory(Appearance appearance, Attribute attribute, String name, String description, double health, char direction, Weapon weapon, Shield shield, DrawStrategy drawStrategy) {
        this.appearance = appearance;
        this.attribute = attribute;
        this.name = name;
        this.description = description;
        this.health = health;
        this.direction = direction;
        this.weapon = weapon;
        this.shield = shield;
        this.drawStrategy = drawStrategy;
    }

    @Override
    public GameObject createGameObject() {
        return new Player(appearance, attribute, name, description, health, direction, weapon, shield, drawStrategy);
    }
}
