package org.ni.rpg.factory;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.*;
import org.ni.rpg.strategy.DrawStrategy;
import org.ni.rpg.strategy.impl.GameObjectDrawStrategy;
import org.ni.rpg.utils.Commons;

public class GameObjectFactory implements GameObjectAbstractFactory {
    @Override
    public Player createPlayer(boolean canMove, boolean goThrough, boolean takeDamage, boolean canBeKilled, boolean killed, boolean removeAfterKilled, int positionX, int positionY, Character[][] content, String color, boolean visible, double attack, int range, int protection, String name, String description, double health, char direction) {
        Attribute attribute = new Attribute(canMove, goThrough, takeDamage, canBeKilled, killed, removeAfterKilled);
        Dimension dimension = Commons.calculateDimension(content);
        Appearance appearance = new Appearance(positionX, positionY, dimension, content, color, visible);
        DrawStrategy drawStrategy = new GameObjectDrawStrategy();
        Weapon weapon = new Weapon(appearance, attribute, attack, range, drawStrategy);
        Shield shield = new Shield(appearance, attribute, protection, drawStrategy);
        return new Player(appearance, attribute, name, description, health, direction, weapon, shield, drawStrategy);
    }
}
