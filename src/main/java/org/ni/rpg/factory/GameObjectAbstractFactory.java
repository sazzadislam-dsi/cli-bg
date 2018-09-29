package org.ni.rpg.factory;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.Player;

public interface GameObjectAbstractFactory {
     Player createPlayer(boolean canMove, boolean goThrough, boolean takeDamage, boolean canBeKilled, boolean killed, boolean removeAfterKilled, int positionX, int positionY, Character[][] content, String color, boolean visible, double attack, int range, int protection, String name, String description, double health, char direction);
}
