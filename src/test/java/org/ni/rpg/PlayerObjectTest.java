package org.ni.rpg;

import org.junit.Test;
import org.ni.rpg.entity.*;
import org.ni.rpg.factory.GameObjectAbstractFactory;
import org.ni.rpg.factory.GameObjectFactory;
import org.ni.rpg.strategy.DrawStrategy;
import org.ni.rpg.strategy.impl.GameObjectDrawStrategy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlayerObjectTest {
    @Test()
    public void testPlayerCreation() {
        Character[][] ch = { {'x'} };

        GameObjectAbstractFactory factory = new GameObjectFactory();
        Player player = factory.createPlayer(true, false, true, true, false, true,0, 0, ch, "red", true, 50, 3,  50,"Nazmul", "wolverine", 100, 'r' );
        System.out.println(player);
        assertNotNull(player);
        assertEquals(player.getName(), "Nazmul");
    }
}
