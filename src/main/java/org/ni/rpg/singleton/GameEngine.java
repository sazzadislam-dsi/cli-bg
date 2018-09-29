package org.ni.rpg.singleton;

import org.ni.rpg.exception.FrameSizeOutOfBound;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameEngine {
    private static final GameEngine instance = new GameEngine();

    MenuEngine menuEngine = MenuEngine.getInstance();

    private GameEngine(){}

    public static GameEngine getInstance(){
        return instance;
    }

    public void init() throws FrameSizeOutOfBound {
        menuEngine.showStartMenu();
    }
}
