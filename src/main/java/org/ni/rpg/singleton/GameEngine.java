package org.ni.rpg.singleton;

import org.ni.rpg.composite.GameObject;
import org.ni.rpg.entity.Dimension;
import org.ni.rpg.entity.GameState;
import org.ni.rpg.entity.Player;
import org.ni.rpg.enums.State;
import org.ni.rpg.exception.FrameSizeOutOfBound;
import org.ni.rpg.factory.GameObjectAbstractFactory;
import org.ni.rpg.factory.GameObjectFactory;
import org.ni.rpg.listener.KeyBoardListener;
import org.ni.rpg.utils.Commons;
import org.ni.rpg.utils.Config;
import org.ni.rpg.utils.Constants;

import java.io.*;
import java.util.List;
import java.util.Random;

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
        if(Commons.isEmpty(Commons.getPlayerName())){
            menuRenderer.showPlayerCreationMenuName();
        }else{
            createGameState(Commons.getPlayerName());
        }
    }

    public void createGameState(String name) throws FrameSizeOutOfBound {
        this.CURRENT_STATE = State.GAME_PLAY;
        gameState = factory.createGameMap(name);
        Commons.setPlayerName(name);
        gameStateRenderer.generateFrame(gameState);
    }

    public void generateFrame() throws FrameSizeOutOfBound {
        gameStateRenderer.generateFrame(gameState);
    }

    public void shutdown() throws FrameSizeOutOfBound {
        menuRenderer.showThanksMenu();
        System.exit(0);
    }

    public void playerMoveRight() throws FrameSizeOutOfBound {
        aiMove();
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        playerMoveRight(player);
        this.generateFrame();

    }

    public void playerMoveRight(Player player) throws FrameSizeOutOfBound {
        if(player.getAppearance().getDirection().equals(GameController.RIGHT)) {
            int positionX = player.getAppearance().getPositionX();
            //if (positionX >= 0 && positionX <= gameState.getAppearance().getDimension().getWidth() - (player.getSpeed()*4) - player.getAppearance().getDimension().getWidth()) {
                if(positionX + (player.getSpeed()*4) + player.getAppearance().getDimension().getWidth() <= gameState.getAppearance().getDimension().getWidth()) {
                    player.getAppearance().setPositionX(positionX + player.getSpeed());
                }else{
                    player.getAppearance().setPositionX(gameState.getAppearance().getDimension().getWidth() - player.getAppearance().getDimension().getWidth());
                }
            //}
        }else{
            player.getAppearance().setDirection(GameController.RIGHT);
        }

    }

    public void playerMoveLeft() throws FrameSizeOutOfBound {
        aiMove();
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        playerMoveLeft(player);
        this.generateFrame();

    }

    public void playerMoveLeft(Player player) throws FrameSizeOutOfBound {
        if(player.getAppearance().getDirection().equals(GameController.LEFT)) {
            int positionX = player.getAppearance().getPositionX();
            //if (positionX > 0 && positionX <= gameState.getAppearance().getDimension().getWidth() + (player.getSpeed()*4) - player.getAppearance().getDimension().getWidth()) {
                if(positionX - (player.getSpeed()*4)>=0) {
                    player.getAppearance().setPositionX(positionX - player.getSpeed());
                }else{
                    player.getAppearance().setPositionX(0);
                }
            //}
        }else{
            player.getAppearance().setDirection(GameController.LEFT);
        }

    }

    public void playerMoveDown() throws FrameSizeOutOfBound {
        aiMove();
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        playerMoveDown(player);
        this.generateFrame();

    }

    public void playerMoveDown(Player player) throws FrameSizeOutOfBound {
        if(player.getAppearance().getDirection().equals(GameController.DOWN)) {
            int positionY = player.getAppearance().getPositionY();
            //if (positionY >= 0 && positionY <= gameState.getAppearance().getDimension().getHeight() - player.getSpeed() - player.getAppearance().getDimension().getHeight()) {
                if(positionY + player.getSpeed() + player.getAppearance().getDimension().getHeight() <= gameState.getAppearance().getDimension().getHeight()) {
                    player.getAppearance().setPositionY(positionY + player.getSpeed());
                }else{
                    player.getAppearance().setPositionY(gameState.getAppearance().getDimension().getHeight() - player.getAppearance().getDimension().getHeight());
                }
            //}
        }else{
            player.getAppearance().setDirection(GameController.DOWN);
        }

    }

    public void playerMoveUp() throws FrameSizeOutOfBound {
        aiMove();
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        playerMoveUp(player);
        this.generateFrame();

    }

    public void playerMoveUp(Player player) throws FrameSizeOutOfBound {
        if(player.getAppearance().getDirection().equals(GameController.UP)) {
            int positionY = player.getAppearance().getPositionY();
            //if (positionY > 0 && positionY <= gameState.getAppearance().getDimension().getHeight() + player.getSpeed() - player.getAppearance().getDimension().getHeight()) {
                if(positionY - player.getSpeed()>=0) {
                    player.getAppearance().setPositionY(positionY - player.getSpeed());
                }else{
                    player.getAppearance().setPositionY(0);
                }
            //}
        }else{
            player.getAppearance().setDirection(GameController.UP);
        }
    }

    public void aiMove() throws FrameSizeOutOfBound {
        List<Player> movableGameObject = gameState.getMovableGameObject();
        for(Player player : movableGameObject){
            int direction = Commons.randInt(1,4);
            if(direction == 1){
                playerMoveUp(player);
            }else if(direction == 2){
                playerMoveDown(player);
            }else if(direction == 3){
                playerMoveLeft(player);
            }else if(direction == 4){
                playerMoveRight(player);
            }
        }
        for(Player player : movableGameObject){
            if(Commons.randInt(1,2)==2) {
                aiAction(player);
            }
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
        FileOutputStream file = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(file);
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
            Player player = (Player) gameState.getGameObjct(gameState.getPlayerId());
            Commons.setPlayerName(player.getName());
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

    public void playerAction() throws FrameSizeOutOfBound {
        aiMove();
        Player player = (Player)gameState.getGameObjct(gameState.getPlayerId());
        aiAction(player);
        this.generateFrame();
    }
    public void aiAction(Player player) throws FrameSizeOutOfBound {
        List<Player> aiPlayerList = gameState.getAllKillAbleGameObject();
        int alive = aiPlayerList.size();
        int killed = 0;
        for(Player aiPlayer: aiPlayerList){
            boolean damageable = false;
            if(!player.getId().equals(aiPlayer.getId()) && player.getAppearance().getDirection().equals(GameController.UP) && aiPlayer.getAppearance().getPositionX() != player.getAppearance().getPositionX() && aiPlayer.getAppearance().getPositionY() > player.getAppearance().getPositionY() && aiPlayer.getAppearance().getPositionY() - player.getWeapon().getRange() < player.getAppearance().getPositionY()) {
                damageable = true;
            }else if (!player.getId().equals(aiPlayer.getId()) && player.getAppearance().getDirection().equals(GameController.DOWN) && aiPlayer.getAppearance().getPositionX() != player.getAppearance().getPositionX() && aiPlayer.getAppearance().getPositionY() < player.getAppearance().getPositionY() && aiPlayer.getAppearance().getPositionY() + player.getWeapon().getRange() > player.getAppearance().getPositionY()){
                damageable = true;
            }else if (!player.getId().equals(aiPlayer.getId()) && player.getAppearance().getDirection().equals(GameController.LEFT) && aiPlayer.getAppearance().getPositionY() != player.getAppearance().getPositionY() && aiPlayer.getAppearance().getPositionX() > player.getAppearance().getPositionX() && aiPlayer.getAppearance().getPositionX() - player.getWeapon().getRange() < player.getAppearance().getPositionX()){
                damageable = true;
            }else if (!player.getId().equals(aiPlayer.getId()) && player.getAppearance().getDirection().equals(GameController.RIGHT) && aiPlayer.getAppearance().getPositionY() != player.getAppearance().getPositionY() && aiPlayer.getAppearance().getPositionX() < player.getAppearance().getPositionX() && aiPlayer.getAppearance().getPositionX() + player.getWeapon().getRange() > player.getAppearance().getPositionX()){
                damageable = true;
            }
            if(damageable) {
                if (aiPlayer.getHealth() - player.getWeapon().getAttack() < 0) {
                    if(aiPlayer.getId().equals(gameState.getPlayerId())){
                        showGameOverMenu();
                    }
                    killed++;

                    player.setHealth(player.getHealth()+50.0);
                    player.setKilled(player.getKilled()+1);
                    player.getWeapon().setAttack(player.getWeapon().getAttack()+1);

                    aiPlayer.setHealth(0.0);
                    Dimension dimension = Commons.calculateDimension(Constants.DEAD_CHAR);
                    aiPlayer.getAppearance().setDimension(dimension);
                    aiPlayer.getAppearance().setContent(Constants.DEAD_CHAR);
                    aiPlayer.getAttribute().setCanBeKilled(false);
                    aiPlayer.getAttribute().setCanMove(false);
                    aiPlayer.getAttribute().setKilled(true);
                    aiPlayer.getAttribute().setTakeDamage(false);
                } else {
                    aiPlayer.setHealth(aiPlayer.getHealth() - player.getWeapon().getAttack());
                }
            }
        }
        if((alive-1) == killed){
            if(player.getId().equals(gameState.getPlayerId())){
                showVictoryMenu();
            } else {
                showGameOverMenu();
            }
        }
    }

    public void showGameOverMenu() throws FrameSizeOutOfBound {
        CURRENT_STATE = State.GAME_OVER;
        menuRenderer.showGameOverMenu();
    }

    public void showVictoryMenu() throws FrameSizeOutOfBound {
        CURRENT_STATE = State.VICTORY;
        menuRenderer.showVictoryMenu();
    }

    public void showHelpMenu() throws FrameSizeOutOfBound {
        CURRENT_STATE = State.HELP;
        menuRenderer.inGameHelpMenu();
    }

    public void returnToGameFromHelpMenu() throws FrameSizeOutOfBound {
        this.CURRENT_STATE = State.GAME_PLAY;
        gameStateRenderer.generateFrame(gameState);
    }
}
