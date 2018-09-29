package org.ni.rpg.singleton;

import org.ni.rpg.entity.GameState;
import org.ni.rpg.enums.State;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.factory.GameObjectAbstractFactory;
import org.ni.rpg.factory.GameObjectFactory;
import org.ni.rpg.listener.KeyBoardListener;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameEngine {
    private static final GameEngine instance = new GameEngine();
    private static State CURRENT_STATE = State.MAIN_MENU;

    MenuRenderer menuRenderer = MenuRenderer.getInstance();
    KeyBoardListener keyBoardListener;
    GameController gameController;
    GameObjectAbstractFactory factory;
    GameStateRenderer gameStateRenderer;
    GameState gameState;

    private GameEngine(){
        keyBoardListener = KeyBoardListener.getInstance(this);
        gameController = GameController.getInstance(this);
        gameStateRenderer = GameStateRenderer.getInstance();
        factory = new GameObjectFactory();
    }

    public static GameEngine getInstance(){
        return instance;
    }

    public void init() throws FrameSizeOutOfBound {
        showStartMenu();
        keyBoardListener.listen();
    }
    public void showStartMenu() throws FrameSizeOutOfBound {
        menuRenderer.showStartMenu();
    }

    public void showStartMenuAnim() throws FrameSizeOutOfBound {
        menuRenderer.showStartMenuAnim();
    }

    public void registerKeyEvent(String givenInput) throws FrameSizeOutOfBound {
        gameController.actionOnKeyEvent(givenInput);
    }

    public State getCURRENT_STATE() {
        return CURRENT_STATE;
    }

    public void setCURRENT_STATE(State CURRENT_STATE) {
        this.CURRENT_STATE = CURRENT_STATE;
    }

    public void playerCreationStart() throws FrameSizeOutOfBound {
        this.CURRENT_STATE = State.PLAYER_CREATION_NAME;
        menuRenderer.showPlayerCreationMenuName();
    }

    public void createGameState(String name) throws FrameSizeOutOfBound {
        this.CURRENT_STATE = State.GAME_PLAY;
        gameState = factory.createGameMap(name);
        gameStateRenderer.generateFrame(gameState);
    }

    public void generateFrame() throws FrameSizeOutOfBound {
        gameStateRenderer.generateFrame(gameState);
    }

    public void shutdown() throws FrameSizeOutOfBound {
        menuRenderer.showThanksMenu();
        System.exit(0);
    }
}
