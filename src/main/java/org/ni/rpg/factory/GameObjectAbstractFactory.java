package org.ni.rpg.factory;

import org.ni.rpg.entity.GameState;
import org.ni.rpg.entity.Player;

public interface GameObjectAbstractFactory {
     Player createPlayer(int positionX, int positionY, Character[][] content, String color, double attack, int range, int protection, String name, String description, double health, char direction, int speed);
     GameState createGameMap(String name);
}
