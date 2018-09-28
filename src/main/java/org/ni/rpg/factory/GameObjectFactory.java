package org.ni.rpg.factory;

import org.ni.rpg.composite.GameObject;

public class GameObjectFactory {
    public static GameObject createGameObject(GameObjectAbstractFactory factory) {
        return factory.createGameObject();
    }
}
