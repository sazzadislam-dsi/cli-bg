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
        Character[][] characters = gameState.draw(gameState.getAppearance().getContent());
        Frame frame = new Frame();
        frame.drawAtPosition(1,1,characters);
        frame.drawBorder();

        System.out.println(frame.getFrameForPrint());
    }
    public Character[][] getGameFrame(GameState gameState) throws FrameSizeOutOfBound {
        return gameState.draw(gameState.getAppearance().getContent());
    }
}
