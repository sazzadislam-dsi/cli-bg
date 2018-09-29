package org.ni.rpg.singleton;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.GameState;
import org.ni.rpg.entity.Player;
import org.ni.rpg.enums.State;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.factory.GameObjectAbstractFactory;
import org.ni.rpg.factory.GameObjectFactory;
import org.ni.rpg.listener.KeyBoardListener;
import org.ni.rpg.utils.Config;

import java.io.*;

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

    public void init() throws FrameSizeOutOfBound, IOException, ClassNotFoundException {
        showStartMenu();
        keyBoardListener.listen();
    }
    public void showStartMenu() throws FrameSizeOutOfBound {
        menuRenderer.showStartMenu();
    }

    public void showStartMenuAnim() throws FrameSizeOutOfBound {
        menuRenderer.showStartMenuAnim();
    }

    public void registerKeyEvent(String givenInput) throws FrameSizeOutOfBound, IOException, ClassNotFoundException {
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

    public void playerMoveRight() {
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        int positionX  = player.getAppearance().getPositionX();
        if(positionX > 0 && positionX < Config.MAX_WIDTH - player.getSpeed()) {
            player.getAppearance().setPositionX(positionX + player.getSpeed());
        }
        try {
            this.generateFrame();
        } catch (FrameSizeOutOfBound frameSizeOutOfBound) {
            frameSizeOutOfBound.printStackTrace();
        }
    }

    public void playerMoveLeft() {
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        int positionX  = player.getAppearance().getPositionX();
        if(positionX > 0 && positionX < Config.MAX_WIDTH - player.getSpeed()) {
            player.getAppearance().setPositionX(positionX - player.getSpeed());
        }
        try {
            this.generateFrame();
        } catch (FrameSizeOutOfBound frameSizeOutOfBound) {
            frameSizeOutOfBound.printStackTrace();
        }
    }

    public void playerMoveDown() {
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        int positionY  = player.getAppearance().getPositionY();
        if(positionY > 0 && positionY < Config.MAX_HEIGHT - player.getSpeed()) {
            player.getAppearance().setPositionY(positionY + player.getSpeed());
        }
        try {
            this.generateFrame();
        } catch (FrameSizeOutOfBound frameSizeOutOfBound) {
            frameSizeOutOfBound.printStackTrace();
        }
    }

    public void playerMoveUp() {
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        int positionY  = player.getAppearance().getPositionY();
        if(positionY > 0 && positionY < Config.MAX_HEIGHT - player.getSpeed()) {
            player.getAppearance().setPositionY(positionY - player.getSpeed());
        }
        try {
            this.generateFrame();
        } catch (FrameSizeOutOfBound frameSizeOutOfBound) {
            frameSizeOutOfBound.printStackTrace();
        }
    }

    public void gamePause() throws FrameSizeOutOfBound {
        this.CURRENT_STATE = State.PAUSE;
        menuRenderer.showPauseMenu(gameStateRenderer.getGameFrame(gameState));
    }

    public void gameResume() throws FrameSizeOutOfBound {
        this.CURRENT_STATE = State.GAME_PLAY;
        gameStateRenderer.generateFrame(gameState);
    }

    public void gameSave() throws IOException, FrameSizeOutOfBound {
        String filename = "gameState.sav";
        FileOutputStream file = new FileOutputStream
                (filename);
        ObjectOutputStream out = new ObjectOutputStream
                (file);
        out.writeObject(gameState);
        out.close();
        file.close();

        menuRenderer.showPauseMenu(gameStateRenderer.getGameFrame(gameState));
    }

    public void gameLoad() throws IOException, FrameSizeOutOfBound, ClassNotFoundException {
        String filename = "gameState.sav";
        File saveFile = new File(filename);
        if(saveFile.exists()) {
            FileInputStream file = new FileInputStream(saveFile);
            ObjectInputStream in = new ObjectInputStream(file);
            gameState = (GameState) in.readObject();
            in.close();
            file.close();
            this.CURRENT_STATE = State.GAME_PLAY;
            gameStateRenderer.generateFrame(gameState);
        }else{
            menuRenderer.showNoSaveFileMenu();
        }
    }

    public void gameReset() throws FrameSizeOutOfBound {
        GameState gameState=null;
        CURRENT_STATE = State.MAIN_MENU;
        menuRenderer.showStartMenu();
    }
}
