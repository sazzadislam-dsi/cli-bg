package org.ni.rpg.singleton;

import org.ni.rpg.enums.State;
import org.ni.rpg.exception.FrameSizeOutOfBound;

import java.io.IOException;

/**
 * Created by nazmul on 9/29/2018.
 */
public class GameController {
    private static GameController singleton = null;
    private GameEngine gameEngine;

    public static final String ONE="1";
    public static final String TWO="2";
    public static final String THREE="3";
    public static final String UP="w";
    public static final String LEFT="a";
    public static final String RIGHT="d";
    public static final String DOWN="s";
    public static final String HELP="h";
    public static final String FIRE="f";

    public synchronized static GameController getInstance(GameEngine gameEngine) {
        if(singleton == null) singleton = new GameController(gameEngine);
        return singleton;
    }

    private GameController(GameEngine gameEngine){
        this.gameEngine = gameEngine;
    }

    public void actionOnKeyEvent(String givenInput) throws FrameSizeOutOfBound, IOException, ClassNotFoundException {
        if(gameEngine.getCURRENT_STATE().equals(State.MAIN_MENU)) {
            if(givenInput.equals(ONE)){
                gameEngine.playerCreationStart();
            }else if(givenInput.equals(TWO)){
                gameEngine.gameLoad();
            }else if(givenInput.equals(THREE)){
                gameEngine.shutdown();
            }else{
                gameEngine.showStartMenu();
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.PLAYER_CREATION_NAME)) {
            if(givenInput.equals(THREE)){
                gameEngine.shutdown();
            }else if(givenInput.equals("")){
                gameEngine.playerCreationStart();
            }else{
                gameEngine.createGameState(givenInput);
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.GAME_PLAY)) {
            if(givenInput.equals(THREE)){
                gameEngine.gamePause();
            }else if(givenInput.equals(UP)){
                gameEngine.playerMoveUp();
            }else if(givenInput.equals(DOWN)){
                gameEngine.playerMoveDown();
            }else if(givenInput.equals(LEFT)){
                gameEngine.playerMoveLeft();
            }else if(givenInput.equals(RIGHT)){
                gameEngine.playerMoveRight();
            }else if(givenInput.equals(ONE)){
                gameEngine.generateFrame();
            }else if(givenInput.equals(TWO)){
                gameEngine.gameSave();
            }else if(givenInput.equals(FIRE)){
                gameEngine.playerAction();
            }else if(givenInput.equals(HELP)){
                gameEngine.showHelpMenu();
            }else{
                gameEngine.generateFrame();
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.PAUSE)) {
            if(givenInput.equals(ONE)){
                gameEngine.gameResume();
            }else if(givenInput.equals(TWO)){
                gameEngine.gameSave();
            }else if(givenInput.equals(THREE)){
                gameEngine.gameReset();
            }else{
                gameEngine.gamePause();
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.HELP)) {
            if(givenInput.equals(ONE)){
                gameEngine.returnToGameFromHelpMenu();
            }else if(givenInput.equals(TWO)){
                gameEngine.gameSave();
            }else if(givenInput.equals(FIRE)){
                gameEngine.playerAction();
            }else if(givenInput.equals(HELP)){
                gameEngine.returnToGameFromHelpMenu();
            }else{
                gameEngine.showHelpMenu();
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.GAME_OVER)) {
            if(givenInput.equals(ONE)){
                gameEngine.playerCreationStart();
            }else if(givenInput.equals(THREE)){
                gameEngine.shutdown();
            }else{
                gameEngine.showGameOverMenu();
            }
        }else if(gameEngine.getCURRENT_STATE().equals(State.VICTORY)) {
            if(givenInput.equals(ONE)){
                gameEngine.playerCreationStart();
            }else if(givenInput.equals(THREE)){
                gameEngine.shutdown();
            }else{
                gameEngine.showVictoryMenu();
            }
        }
    }

}
