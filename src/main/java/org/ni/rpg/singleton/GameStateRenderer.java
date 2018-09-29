package org.ni.rpg.singleton;

import org.ni.rpg.entity.Frame;
import org.ni.rpg.entity.GameState;
import org.ni.rpg.exception.FrameSizeOutOfBound;

/**
 * Created by nazmul on 9/30/2018.
 */
public class GameStateRenderer {
    private static final GameStateRenderer instance = new GameStateRenderer();

    private GameStateRenderer(){}

    public static GameStateRenderer getInstance(){
        return instance;
    }

    public void generateFrame(GameState gameState) throws FrameSizeOutOfBound {
//        for(int i = 0; i < 100; i++) System.out.println();

        Character[][] characters = gameState.draw(gameState.getAppearance().getContent());
        Frame frame = new Frame();
        frame.drawAtPosition(0,0,characters);
        frame.drawBorder();
        System.out.println(frame.getFrameForPrint());
    }
}
