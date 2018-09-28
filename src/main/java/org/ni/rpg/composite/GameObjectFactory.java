package org.ni.rpg.composite;

public class GameObjectFactory {
    public static GameObject getGameObject(GameObjectAbstractFactory factory) {
        return factory.createGameObject();
    }
}
