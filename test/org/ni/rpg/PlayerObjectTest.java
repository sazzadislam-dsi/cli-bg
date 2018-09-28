package org.ni.rpg;

import org.junit.Test;
import org.ni.rpg.composite.GameObject;
import org.ni.rpg.composite.GameObjectFactory;
import org.ni.rpg.entity.*;
import org.ni.rpg.strategy.DrawStrategy;
import org.ni.rpg.strategy.impl.GameObjectDrawStrategy;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerObjectTest {
    @Test()
    public void testPlayerCreation() {
        char[][] ch = { {'-', '-'}, {'-', '-'} };

        Attribute attribute = new Attribute(true, false, true, true, false, true);
        Appearance appearance = new Appearance(0, 0, 4, 4, ch, "red", true);
        DrawStrategy drawStrategy = new GameObjectDrawStrategy();
        Weapon weapon = new Weapon(appearance, attribute, 50, 3, drawStrategy);
        Shield shield = new Shield(appearance, attribute, 50, drawStrategy);

        GameObject player = GameObjectFactory.getGameObject(new PlayerFactory(appearance, attribute, "Nazmul", "wolverine", 100, 'r', weapon, shield, drawStrategy));
        System.out.println(player);
        assertNotNull(player);
        assertEquals(player.getName(), "Nazmul");
    }
}
